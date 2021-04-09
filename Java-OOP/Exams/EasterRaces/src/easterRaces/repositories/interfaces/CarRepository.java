package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarRepository implements Repository<Car>{
    private List<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        Car car = null;
        for (Car model : models) {
            if (model.getModel().equals(name)){
                car = model;
            }
        }
        return car;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Car model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return this.models.remove(model);
    }
}
