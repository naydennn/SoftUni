package bakery.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class RepositoryImpl<T> implements Repository<T> {

    private List<T> models;

    public RepositoryImpl () {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(T o) {
        this.models.add(o);
    }
}
