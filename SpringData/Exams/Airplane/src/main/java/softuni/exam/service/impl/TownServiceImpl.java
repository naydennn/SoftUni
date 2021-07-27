package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TownSeedDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;
    private final Gson gson;

    public TownServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, TownRepository townRepository, Gson gson) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.gson = gson;
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
                    boolean isValid = validationUtil.isValid(town);

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                            town.getName(), town.getPopulation()) : "Invalid town");
                    sb.append(System.lineSeparator());
                    return isValid;
                })
                .map(town -> {
                    Town mappedTown = modelMapper.map(town, Town.class);

                    mappedTown.setDescription(town.getGuide());
                    return mappedTown;
                }).forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town getRandomTown(String town) {
        return townRepository.findByName(town);
    }
}
