package bg.softuni.json_intro.services;

import bg.softuni.json_intro.models.dtos.ProductInRangeDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductInRangeDto> getAllProductInRange();
}
