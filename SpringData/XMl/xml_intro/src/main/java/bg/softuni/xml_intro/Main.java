package bg.softuni.xml_intro;

import bg.softuni.xml_intro.models.dtos.seed.CategorySeedRootDto;
import bg.softuni.xml_intro.models.dtos.seed.ProductSeedRootDto;
import bg.softuni.xml_intro.models.dtos.seed.UserSeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.CategoryRootViewDto;
import bg.softuni.xml_intro.models.dtos.view.ProductViewRootDto;
import bg.softuni.xml_intro.models.dtos.view.UserWithSoldProductsRootDto;
import bg.softuni.xml_intro.services.CategoryService;
import bg.softuni.xml_intro.services.ProductService;
import bg.softuni.xml_intro.services.UserService;
import bg.softuni.xml_intro.utils.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

@Component
public class Main implements CommandLineRunner {

    public static final String RESOURCES_FILE_PATH = "src/main/resources/";
    public static final String USERS_FILE_NAME = "resources/users.xml";
    public static final String CATEGORIES_FILE_NAME = "resources/categories.xml";
    public static final String PRODUCTS_FILE_NAME = "resources/products.xml";
    public static final String PRODUCTS_IN_RANGE_OUTPUT = "output/products-in-range.xml";
    public static final String USER_SOLD_PRODUCTS_OUTPUT = "output/user-sold-product.xml";
    public static final String CATEGORIES_BY_PRODUCTS_OUTPUT = "output/categories-by-product.xml";

    private final XmlParser xmlParser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final BufferedReader reader;

    public Main(XmlParser xmlParser, UserService userService, CategoryService categoryService, ProductService productService, BufferedReader reader) {
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Please write a exercise number:");

        int numOfExercises = Integer.parseInt(reader.readLine());

        switch (numOfExercises) {
            case 1 -> productsInRange();
            case 2 -> userWithSoldProducts();
            case 3 -> categoriesByProductCount();
        }
    }

    private void categoriesByProductCount() throws JAXBException, FileNotFoundException {
        CategoryRootViewDto allCategoryOrderByProductSize = categoryService.getAllCategoryOrderByProductSize();

        xmlParser.toFile(RESOURCES_FILE_PATH + CATEGORIES_BY_PRODUCTS_OUTPUT, allCategoryOrderByProductSize);

    }

    private void userWithSoldProducts() throws JAXBException, FileNotFoundException {
        UserWithSoldProductsRootDto userWithSoldProducts = userService.getUserWithSoldProducts();

        xmlParser.toFile(RESOURCES_FILE_PATH + USER_SOLD_PRODUCTS_OUTPUT,
                userWithSoldProducts);
    }

    private void productsInRange() throws JAXBException, FileNotFoundException {
        ProductViewRootDto allProductsInRange = productService.getAllProductsInRange();

        xmlParser.toFile(RESOURCES_FILE_PATH + PRODUCTS_IN_RANGE_OUTPUT,
                allProductsInRange);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        userService.seedData(xmlParser
                .fromFile(RESOURCES_FILE_PATH + USERS_FILE_NAME, UserSeedRootDto.class));
        categoryService.seedData(xmlParser
                .fromFile(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME, CategorySeedRootDto.class));
        productService.seedData(xmlParser.
                fromFile(RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME, ProductSeedRootDto.class));
    }
}
