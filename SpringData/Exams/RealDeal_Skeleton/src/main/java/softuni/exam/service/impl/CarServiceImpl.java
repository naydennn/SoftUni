package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static final String CARS_FILE_NAME = "src/main/resources/files/json/cars.json";

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CarRepository carRepository;

    public CarServiceImpl(Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CarRepository carRepository) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_NAME));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        String content = Files.readString(Path.of(CARS_FILE_NAME));

        CarSeedDto[] carSeedDto = gson.fromJson(content, CarSeedDto[].class);

        Arrays.stream(carSeedDto)
                .filter(car -> {
                    boolean isValid = validationUtil.isValid(car);

                    sb.append(isValid ?
                            String.format("Successfully imported car - %s - %s",
                                    car.getMake(), car.getModel()) :
                            "Invalid car")
                    .append(System.lineSeparator());
                    return isValid;
                })
                .map(car -> modelMapper.map(car, Car.class))
                .forEach(carRepository::save);

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        List<Car> allCarOrderedByPictureDescThenByMake = carRepository.getAllCarOrderedByPictureDescThenByMake();

        StringBuilder stringBuilder = new StringBuilder();

        allCarOrderedByPictureDescThenByMake.forEach(car -> {
            stringBuilder.append(String.format("Car make - %s, model - %s\n" +
                            "\tKilometers - %d\n" +
                            "\tRegistered on - %s\n" +
                            "\tNumber of pictures - %d\n",
                    car.getMake(), car.getModel() ,car.getKilometers(),
                    car.getRegisteredOn(), car.getPictures().size()
                    ));
        });

        return stringBuilder.toString();
    }

    @Override
    public Car getCar(Long car) {
        return carRepository.getOne(car);
    }
}
