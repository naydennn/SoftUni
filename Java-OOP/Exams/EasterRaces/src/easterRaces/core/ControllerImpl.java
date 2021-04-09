package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Car>  carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.carRepository = motorcycleRepository;
        this.driverRepository = riderRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (this.driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        this.driverRepository.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (this.carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        switch (type) {
            case "Muscle":
                this.carRepository.add(new MuscleCar(model, horsePower));
                break;
            case "Sports":
                this.carRepository.add(new SportsCar(model, horsePower));
                break;
        }
        return String.format(CAR_CREATED, this.carRepository.getByName(model).getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (this.driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        this.driverRepository.getByName(driverName).addCar(this.carRepository.getByName(carModel));
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        this.raceRepository.getByName(raceName).addDriver(this.driverRepository.getByName(driverName));

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> collect = race.getDrivers().stream()
                .sorted((f,s) -> (int) (s.getCar().calculateRacePoints(race.getLaps()) - f.getCar().calculateRacePoints(race.getLaps())))
                .limit(3).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();

        result.append(String.format(DRIVER_FIRST_POSITION, collect.get(0).getName(), race.getName())).append(System.lineSeparator())
                .append(String.format(DRIVER_SECOND_POSITION, collect.get(1).getName(), race.getName())).append(System.lineSeparator())
                .append(String.format(DRIVER_THIRD_POSITION, collect.get(2).getName(), race.getName())).append(System.lineSeparator());
        return result.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }
}
