package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
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
public class TownServiceImpl implements TownService {

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(ModelMapper modelMapper, Gson gson, TownRepository townRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownSeedDto[].class))
                .filter(town -> {
                    boolean isValid = validationUtil.isValid(town) && townRepository.findByName(town.getName()) == null;

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                            town.getName(), town.getPopulation()) : "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(town -> modelMapper.map(town, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town getTown(String townName) {

        return townRepository.findByName(townName);
    }
}
