package bg.softuni.json_ex.services.impl;

import bg.softuni.json_ex.models.dtos.SeedDtos.CarSeedDto;
import bg.softuni.json_ex.models.dtos.View.CarWithPartsDto;
import bg.softuni.json_ex.models.dtos.View.ViewToyotaCar;
import bg.softuni.json_ex.models.entities.Car;
import bg.softuni.json_ex.repositories.CarRepository;
import bg.softuni.json_ex.services.CarService;
import bg.softuni.json_ex.services.PartServices;
import bg.softuni.json_ex.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.json_ex.constraints.GlobalConstraints.FILE_INPUT_PATH;

@Service
public class CarServiceImpl implements CarService {

    private final static String FILE_NAME = "cars.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CarRepository carRepository;
    private final ValidatorUtil validatorUtil;
    private final PartServices partServices;

    public CarServiceImpl(ModelMapper modelMapper, Gson gson, CarRepository carRepository, ValidatorUtil validatorUtil, PartServices partServices) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.carRepository = carRepository;
        this.validatorUtil = validatorUtil;
        this.partServices = partServices;
    }

    @Override
    public void seedData() throws IOException {

        if (carRepository.count() == 0) {
            String content = Files.readString(Path.of(FILE_INPUT_PATH + FILE_NAME));

            Arrays.stream(gson.fromJson(content, CarSeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
                    .forEach(car -> {
                        car.setParts(partServices.getRandomParts());
                        carRepository.save(car);
                    });
        }
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.getAllBy();
    }

    @Override
    public List<ViewToyotaCar> getAllCarByToyota(String model) {
        return carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc(model)
                .stream()
                .map(car -> modelMapper.map(car, ViewToyotaCar.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarWithPartsDto> getAllCarsWithTheirParts() {
        return carRepository.getAllBy().stream()
                .map(car -> modelMapper.map(car, CarWithPartsDto.class))
                .collect(Collectors.toList());
    }
}
