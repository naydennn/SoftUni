package bg.softuni.xml_intro.services;

import bg.softuni.xml_intro.models.dtos.seed.CategorySeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.CategoryRootViewDto;
import bg.softuni.xml_intro.models.entities.Category;

import java.util.Set;

public interface CategoryService {

    void seedData(CategorySeedRootDto categorySeedRootDto);

    Set<Category> getRandomCategories();

    CategoryRootViewDto getAllCategoryOrderByProductSize();
}
