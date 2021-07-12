package com.example.demo.services.impl;

import com.example.demo.models.entity.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryServices;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServicesImpl implements CategoryServices {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> getRandomCategories() {

        int rndCountCategories = ThreadLocalRandom.current().nextInt(1, 3);
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < rndCountCategories; i++) {
            Long randId = ThreadLocalRandom.current()
                    .nextLong(1, categoryRepository.count() + 1);

            categories.add(categoryRepository.findById(randId).orElse(null));
        }

        return categories;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() < 1) {
            Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                    .stream()
                    .filter(catName -> !catName.isEmpty())
                    .forEach(catName -> {
                        Category category = new Category(catName);

                        categoryRepository.save(category);
                    });
        }
    }
}
