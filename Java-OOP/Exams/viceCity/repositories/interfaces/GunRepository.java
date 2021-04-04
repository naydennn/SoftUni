package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun>{

    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(Gun model) {
        boolean isExist = this.models.stream().anyMatch(g -> g.getName().equals(model.getName()));
        if (!isExist) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models.stream().filter(g -> g.getName().equals(name)).findFirst().get();
    }
}
