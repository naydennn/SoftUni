package core;

import interfaces.Entity;
import interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Data implements Repository {

    private List<Entity> entities;

    public Data() {
        this.entities = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.entities.add(entity);

        swim(this.entities.size() - 1);
    }

    private void swim(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index -1) / 2;

        if (isLessThan(index, parentIndex)) {
            swapElements(index, parentIndex);
            swim(parentIndex);
        }
    }

    private void swapElements(int index, int parentIndex) {
        Entity oldEntity = this.entities.get(parentIndex);
        this.entities.set(parentIndex, entities.get(index));
        this.entities.set(index, oldEntity);
    }

    private boolean isLessThan(int index, int parentIndex) {
        return (entities.get(index).getId() - entities.get(parentIndex).getId()) > 0;
    }

    @Override
    public Entity getById(int id) {
        for (Entity entity : this.entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public List<Entity> getByParentId(int id) {
        List<Entity> result = new ArrayList<>();

        for (Entity entity : entities) {
            if (entity.getParentId() == id) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public List<Entity> getAll() {
        return this.entities;
    }

    @Override
    public Repository copy() {
        Data data = new Data();
        for (Entity entity : this.entities) {
            data.add(entity);
        }
        return data;
    }

    @Override
    public List<Entity> getAllByType(String type) {
        if (!(type.equals("Invoice") || type.equals("StoreClient") || type.equals("User"))) {
            throw new IllegalArgumentException("Illegal type: " + type);
        }

        List<Entity> result = new ArrayList<>();

        for (Entity entity : this.entities) {
            if (entity.getClass().getSimpleName().equals(type)) {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public Entity peekMostRecent() {
        if (this.entities.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }
        return this.entities.get(0);
    }

    @Override
    public Entity pollMostRecent() {
        if (entities.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }
        Entity maxElement = entities.get(0);

        this.entities.set(0, entities.get(entities.size() - 1));
        this.entities.remove(entities.size() -1);

        sink(0);
        return maxElement;
    }

    private void sink(int index) {
        int firstChild = (index * 2) + 1;
        int secondChild = (index * 2) + 2;

        if (!isValidIndex(firstChild)) {
            return;
        }

        int maxIndex;
        if (isValidIndex(secondChild) && isLessThan(secondChild, firstChild)) {
            maxIndex = secondChild;
        } else {
            maxIndex = firstChild;
        }
        swapElements(index, maxIndex);
        sink(maxIndex);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < entities.size();
    }

    @Override
    public int size() {
        return entities.size();
    }
}
