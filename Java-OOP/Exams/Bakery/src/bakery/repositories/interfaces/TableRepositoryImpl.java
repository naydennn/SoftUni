package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

import java.util.Collection;

public class TableRepositoryImpl extends RepositoryImpl implements TableRepository{
    @Override
    public Object getByNumber(int number) {
        Collection<Table> all = super.getAll();

        Table table = null;

        for (Table tab : all) {
            if (tab.getTableNumber() == number) {
                table = tab;
            }
        }
        return table;
    }
}
