package bg.softuni.exap_prep.init;

import bg.softuni.exap_prep.models.entities.Category;
import bg.softuni.exap_prep.models.entities.enums.CategoryNameEnum;
import bg.softuni.exap_prep.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DBInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            initCategories();
        }
    }

    private void initCategories() {
        Arrays.stream(CategoryNameEnum.values())
                .forEach(c -> {
                        Category category = new Category();
                        switch (c){
                            case CAKE -> category.setName(c).setNeededTime(10);
                            case DRINK -> category.setName(c).setNeededTime(1);
                            case COFFEE -> category.setName(c).setNeededTime(2);
                            case OTHER -> category.setName(c).setNeededTime(5);
                        }

                        categoryRepository.save(category);
                });
    }
}
