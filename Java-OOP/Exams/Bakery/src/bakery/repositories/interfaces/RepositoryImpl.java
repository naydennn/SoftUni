package bakery.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RepositoryImpl<T> implements Repository<T> {

    private Collection<T> models;

    public RepositoryImpl () {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(T o) {
        this.models.add(o);
    }
}
