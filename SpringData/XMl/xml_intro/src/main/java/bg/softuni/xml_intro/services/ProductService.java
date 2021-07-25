package bg.softuni.xml_intro.services;

import bg.softuni.xml_intro.models.dtos.seed.ProductSeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.ProductViewRootDto;

public interface ProductService {
    void seedData(ProductSeedRootDto productSeedRootDto);

    ProductViewRootDto getAllProductsInRange();
}
