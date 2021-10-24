package bg.softuni.exam.service;

import bg.softuni.exam.model.entity.Category;
import bg.softuni.exam.model.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
