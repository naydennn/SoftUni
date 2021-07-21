package bg.softuni.json_intro.services;

import bg.softuni.json_intro.models.dtos.CategoriesByProductDto;
import bg.softuni.json_intro.models.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedProducts() throws IOException;

    Set<Category> getRandomCategories();

    List<CategoriesByProductDto> getAllCategoriesByProductOrderByProduct();
}
