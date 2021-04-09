package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceRepository implements Repository<Race> {

    private List<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;

        for (Race model : models) {
            if (model.getName().equals(name)) {
                race = model;
            }
        }

        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.models.remove(model);
    }
}
