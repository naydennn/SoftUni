package bg.softuni.json_intro;

import bg.softuni.json_intro.models.dtos.CategoriesByProductDto;
import bg.softuni.json_intro.models.dtos.ProductInRangeDto;
import bg.softuni.json_intro.services.CategoryService;
import bg.softuni.json_intro.services.ProductService;
import bg.softuni.json_intro.services.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static bg.softuni.json_intro.constraints.GlobalConstraint.WRITE_FILE_PATH;

@Component
public class Main implements CommandLineRunner {

    public static final String PRODUCT_IN_RANGE_FILE_NAME = "products-in-range";
    public static final String USER_SOLD_PRODUCT_FILE_NAME = "users-sold-products";
    public static final String CATEGORIES_BY_PRODUCT = "categories-by-products";

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Gson gson;

    public Main(UserService userService, ProductService productService, CategoryService categoryService, Gson gson) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        productsInRange();
//        successfullySoldProducts();
          categoriesByProductsCount();
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoriesByProductDto> byProduct = categoryService.getAllCategoriesByProductOrderByProduct();

        writeToFile(WRITE_FILE_PATH + CATEGORIES_BY_PRODUCT,
                gson.toJson(byProduct));
    }

    private void successfullySoldProducts() throws IOException {
        writeToFile(WRITE_FILE_PATH + USER_SOLD_PRODUCT_FILE_NAME,gson
                .toJson(userService.getUserWithMoreThanOneSoldProducts()));
    }

    private void productsInRange() throws IOException {
        List<ProductInRangeDto> allProductInRange = productService.getAllProductInRange();
        String content = gson.toJson(allProductInRange);
        writeToFile(WRITE_FILE_PATH + PRODUCT_IN_RANGE_FILE_NAME,content);
    }

    private void writeToFile(String path, String content) throws IOException {
        Files.write(Path.of(path), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        userService.seedUsers();
        categoryService.seedProducts();
        productService.seedProducts();
    }
}
