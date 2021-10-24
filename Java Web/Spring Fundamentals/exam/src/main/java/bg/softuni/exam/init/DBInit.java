package bg.softuni.exam.init;

import bg.softuni.exam.model.entity.Category;
import bg.softuni.exam.model.enums.CategoryNameEnum;
import bg.softuni.exam.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DBInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }

}
