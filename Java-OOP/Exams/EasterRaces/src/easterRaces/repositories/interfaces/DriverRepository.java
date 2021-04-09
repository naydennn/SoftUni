package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DriverRepository implements Repository<Driver> {
    private List<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        Driver driver =null;

        for (Driver model : this.models) {
            if (model.getName().equals(name)) {
                driver = model;
            }
        }
        return driver;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Driver model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return this.models.remove(model);
    }
}
