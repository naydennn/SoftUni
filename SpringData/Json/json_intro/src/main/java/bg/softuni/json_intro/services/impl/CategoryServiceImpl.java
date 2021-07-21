package bg.softuni.json_intro.services.impl;


import bg.softuni.json_intro.models.dtos.CategoriesByProductDto;
import bg.softuni.json_intro.models.dtos.CategorySeedDto;
import bg.softuni.json_intro.models.entities.Category;
import bg.softuni.json_intro.repositories.CategoriesRepository;
import bg.softuni.json_intro.services.CategoryService;
import bg.softuni.json_intro.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static bg.softuni.json_intro.constraints.GlobalConstraint.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    public static final String CATEGORY_FILE_PATH = "categories.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CategoriesRepository categoriesRepository;
    private final ValidatorUtil validatorUtil;

    public CategoryServiceImpl(ModelMapper modelMapper, Gson gson, CategoriesRepository categoriesRepository, ValidatorUtil validatorUtil) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.categoriesRepository = categoriesRepository;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedProducts() throws IOException {
        if (categoriesRepository.count() == 0) {
            Arrays.stream(gson.fromJson(Files.readString(Path.of(RESOURCES_FILE_PATH + CATEGORY_FILE_PATH)),
                    CategorySeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoriesRepository::save);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        int randomNumOfCategory = ThreadLocalRandom.current().nextInt(1, 4);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < randomNumOfCategory; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1, categoriesRepository.count() + 1);

            categories.add(categoriesRepository.findById(randomId).orElse(null));
        }

        return categories;
    }

    @Override
    public List<CategoriesByProductDto> getAllCategoriesByProductOrderByProduct() {

        return categoriesRepository.getAllCategoriesOrderByNumberOfProducts()
        .stream()
        .map(objects -> {
            CategoriesByProductDto categories = new CategoriesByProductDto();
            categories.setName((String) objects[0]);
            categories.setProductsCount(Integer.parseInt(String.valueOf(objects[1])));
            categories.setAveragePrice(new BigDecimal(String.valueOf(objects[2])));
            categories.setTotalRevenue(new BigDecimal(String.valueOf(objects[3])));
            return categories;
        }).collect(Collectors.toList());


    }
}w
