package bg.softuni.xml_intro.services.impl;

import bg.softuni.xml_intro.models.dtos.seed.CategorySeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.CategoryNameProductsCountAverageAndTotalPricesDto;
import bg.softuni.xml_intro.models.dtos.view.CategoryRootViewDto;
import bg.softuni.xml_intro.models.entities.Category;
import bg.softuni.xml_intro.repositories.CategoryRepository;
import bg.softuni.xml_intro.services.CategoryService;
import bg.softuni.xml_intro.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedData(CategorySeedRootDto categorySeedRootDto) {
        if (categoryRepository.count() == 0) {
            categorySeedRootDto.getCategories().stream()
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {

        int randomNumOfCategory = ThreadLocalRandom
                .current().nextInt(1, 4);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < randomNumOfCategory; i++) {
            Long randomId = ThreadLocalRandom
                    .current().nextLong(1, categoryRepository.count() + 1);

            categories.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }

    @Override
    public CategoryRootViewDto getAllCategoryOrderByProductSize() {
        List<CategoryNameProductsCountAverageAndTotalPricesDto> categories = categoryRepository.findAllAndOrderByProductSize();

        CategoryRootViewDto categoryRootViewDto = new CategoryRootViewDto();

        categoryRootViewDto.setCategories(categories);

        return categoryRootViewDto;
    }
}
