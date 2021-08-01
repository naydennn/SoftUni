package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final TeamRepository teamRepository;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public TeamServiceImpl(ModelMapper modelMapper, Gson gson, TeamRepository teamRepository, ValidationUtil validationUtil, TownService townService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.teamRepository = teamRepository;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class))
                .filter(team -> {
                    boolean isValid = validationUtil.isValid(team) &&
                            teamRepository.findByName(team.getName()) == null;

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d",
                            team.getName(), team.getFanBase()) : "Invalid Team")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(team -> {
                    Team mappedTeam = modelMapper.map(team, Team.class);
                    mappedTeam.setTown(townService.getTown(team.getTownName()));

                    return mappedTeam;
                })
                .forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public Team getTeam(String name) {
        return teamRepository.findByName(name);
    }
}
