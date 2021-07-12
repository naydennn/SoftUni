package com.example.demo.services;

import com.example.demo.models.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryServices {

    Set<Category> getRandomCategories();

    void seedCategories() throws IOException;
}
