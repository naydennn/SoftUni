package bg.softuni.json_ex.services;

import bg.softuni.json_ex.models.dtos.View.CarWithPartsDto;
import bg.softuni.json_ex.models.dtos.View.ViewToyotaCar;
import bg.softuni.json_ex.models.entities.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedData() throws IOException;

    List<Car> getAllCar();

    List<ViewToyotaCar> getAllCarByToyota(String model);

    List<CarWithPartsDto> getAllCarsWithTheirParts();
}
