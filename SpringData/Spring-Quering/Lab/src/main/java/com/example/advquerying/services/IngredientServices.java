package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientServices {

    List<String> findAllByNameStartingWith(String pattern);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

}
