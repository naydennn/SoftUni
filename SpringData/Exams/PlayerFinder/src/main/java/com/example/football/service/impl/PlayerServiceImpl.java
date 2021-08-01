package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYER_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PlayerRepository playerRepository;
    private final ValidationUtil validationUtil;
    private final StatService statService;
    private final TownService townService;
    private final TeamService teamService;

    public PlayerServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, PlayerRepository playerRepository, ValidationUtil validationUtil, StatService statService, TownService townService, TeamService teamService) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.playerRepository = playerRepository;
        this.validationUtil = validationUtil;
        this.statService = statService;
        this.townService = townService;
        this.teamService = teamService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto = xmlParser.fromXml(PLAYER_FILE_PATH, PlayerSeedRootDto.class);

        playerSeedRootDto.getPlayers().stream()
                .filter(player -> {
                    boolean isValid = validationUtil.isValid(player) &&
                            playerRepository.findByEmail(player.getEmail()) == null;

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                            player.getFirstName(), player.getLastName(), player.getPosition()) :
                            "Invalid Player").append(System.lineSeparator());

                    return isValid;
                })
                .map(player -> {
                    Player mappedPlayer = modelMapper.map(player, Player.class);

                    mappedPlayer.setTeam(teamService.getTeam(player.getTeam().getName()));
                    mappedPlayer.setTown(townService.getTown(player.getTown().getName()));
                    mappedPlayer.setStat(statService.getStat(player.getStat().getId()));

                    return mappedPlayer;
                })
                .forEach(playerRepository::save);


        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();

        playerRepository.getBestPlayerOrdered()
                .forEach(player -> sb.append(String.format("Player - %s %s\n" +
                        "\tPosition - %s\n" +
                        "\tTeam - %s\n" +
                        "\tStadium - %s\n", player.getFirstName(), player.getLastName(),
                        player.getPosition().toString(), player.getTeam().getName(),
                        player.getTeam().getStadiumName())));

        return sb.toString();
    }
}
