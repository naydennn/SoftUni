package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientServices {

    List<String> findAllByNameStartingWith(String pattern);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    int deleteByName(String name);

    int increasePriceBy10Percent();

    int updateIngredientPriceByGivenNameAndPercent(String name, BigDecimal percent);

}
