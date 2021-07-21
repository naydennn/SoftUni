package bg.softuni.json_ex.services;


import bg.softuni.json_ex.models.dtos.View.SupplierView;
import bg.softuni.json_ex.models.entities.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    void seedData() throws IOException;

    Supplier getRandomSupplier();

    List<SupplierView> getLocalSupplierWithParts();
}
