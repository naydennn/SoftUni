package bg.softuni.json_ex.services.impl;

import bg.softuni.json_ex.models.dtos.SeedDtos.PartSeedDto;
import bg.softuni.json_ex.models.entities.Part;
import bg.softuni.json_ex.repositories.PartRepository;
import bg.softuni.json_ex.services.PartServices;
import bg.softuni.json_ex.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static bg.softuni.json_ex.constraints.GlobalConstraints.FILE_INPUT_PATH;

@Service
public class PartServicesImpl implements PartServices {

    public static final String FILE_NAME = "parts.json";

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final PartRepository partRepository;
    private final Gson gson;
    private final SupplierServiceImpl supplierService;

    public PartServicesImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, PartRepository partRepository, Gson gson, SupplierServiceImpl supplierService) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.partRepository = partRepository;
        this.gson = gson;
        this.supplierService = supplierService;
    }

    @Override
    public void seedData() throws IOException {
        String content = Files.readString(Path.of(FILE_INPUT_PATH + FILE_NAME));

        if (partRepository.count() == 0) {
            Arrays.stream(gson.fromJson(content, PartSeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(partSeedDto -> modelMapper.map(partSeedDto, Part.class))
                    .forEach(part -> {
                        part.setSupplier(supplierService.getRandomSupplier());
                        partRepository.save(part);
                    });

        }
    }

    @Override
    public List<Part> getRandomParts() {

        List<Part> parts = new ArrayList<>();

        int upperBound = ThreadLocalRandom.current().nextInt(3, 6);

        for (int i = 0; i <upperBound; i++) {
            Long id = ThreadLocalRandom.current().nextLong(1, partRepository.count() + 1);


            parts.add(partRepository.findById(id).orElse(null));
        }
        return parts;
    }
}
