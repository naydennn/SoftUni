package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.entity.Category;
import bg.softuni.exam.model.enums.CategoryNameEnum;
import bg.softuni.exam.repository.CategoryRepository;
import bg.softuni.exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        switch (categoryNameEnum) {
                            case CARGO -> category.setName(categoryNameEnum).setDescription("Cargo ship.");
                            case BATTLE -> category.setName(categoryNameEnum).setDescription("Battle ship.");
                            case PATROL -> category.setName(categoryNameEnum).setDescription("Patrol ship.");
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
