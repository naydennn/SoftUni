package bg.softuni.json_intro.services.impl;

import bg.softuni.json_intro.models.dtos.ProductInRangeDto;
import bg.softuni.json_intro.models.dtos.ProductSeedDto;
import bg.softuni.json_intro.models.entities.Product;
import bg.softuni.json_intro.repositories.ProductsRepository;
import bg.softuni.json_intro.services.CategoryService;
import bg.softuni.json_intro.services.ProductService;
import bg.softuni.json_intro.services.UserService;
import bg.softuni.json_intro.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.json_intro.constraints.GlobalConstraint.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    public static final String PRODUCTS_FILE_PATH = "products.json";

    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final ProductsRepository productsRepository;
    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, ProductsRepository productsRepository, Gson gson, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.productsRepository = productsRepository;
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productsRepository.count() == 0) {
            String fileContent = Files
                    .readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_FILE_PATH));

            Arrays.stream(gson.fromJson(fileContent, ProductSeedDto[].class))
                    .filter(validatorUtil::isValid)
                    .map(product -> modelMapper.map(product, Product.class))
                    .forEach(product -> {
                        product.setSeller(userService.getRandomUser());
                        if (product.getPrice().compareTo(BigDecimal.valueOf(500L)) < 0) {
                            product.setBuyer(userService.getRandomUser());
                        }

                        product.setCategories(categoryService.getRandomCategories());
                        productsRepository.save(product);
                    });
        }
    }

    @Override
    public List<ProductInRangeDto> getAllProductInRange() {
        return productsRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(product -> {
                    ProductInRangeDto productInRangeDto = modelMapper.map(product, ProductInRangeDto.class);
                    productInRangeDto.setSeller(String.format("%s %s",  product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));
                    return productInRangeDto;
                })
                .collect(Collectors.toList());
    }
}
