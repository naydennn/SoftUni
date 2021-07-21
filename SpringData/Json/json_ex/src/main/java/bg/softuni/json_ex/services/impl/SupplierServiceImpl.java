package bg.softuni.json_ex.services.impl;

import bg.softuni.json_ex.models.dtos.SeedDtos.SupplierSeedDto;
import bg.softuni.json_ex.models.dtos.View.SupplierView;
import bg.softuni.json_ex.models.entities.Supplier;
import bg.softuni.json_ex.repositories.SupplierRepository;
import bg.softuni.json_ex.services.SupplierService;
import bg.softuni.json_ex.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static bg.softuni.json_ex.constraints.GlobalConstraints.FILE_INPUT_PATH;

@Service
public class SupplierServiceImpl implements SupplierService {

    public static final String FILE_NAME = "suppliers.json";

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final SupplierRepository supplierRepository;
    private final Gson gson;

    public SupplierServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, SupplierRepository supplierRepository, Gson gson) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.supplierRepository = supplierRepository;
        this.gson = gson;
    }

    @Override
    public void seedData() throws IOException {

        if (supplierRepository.count() == 0) {

            String content = Files.readString(Path.of(FILE_INPUT_PATH + FILE_NAME));
            Arrays.stream(gson.fromJson(content, SupplierSeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(supplierSeedDto ->
                            modelMapper.map(supplierSeedDto, Supplier.class))
                    .forEach(supplierRepository::save);

        }


    }

    @Override
    public Supplier getRandomSupplier() {

        Long randomId = ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1);
        return supplierRepository.getById(randomId);
    }

    @Override
    public List<SupplierView> getLocalSupplierWithParts() {
//        List<SupplierView> allSuppliersWithParts = supplierRepository.getAllSuppliersWithParts();
//        return allSuppliersWithParts;
        return null;
    }
}
