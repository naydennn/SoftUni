package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServicesImpl implements IngredientServices {

    private final IngredientRepository ingredientRepository;

    public IngredientServicesImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findAllByNameStartingWith(String pattern) {
        return ingredientRepository.findAllByNameStartingWith(pattern)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name) {
        return ingredientRepository.findAllByNameInOrderByPrice(name);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return ingredientRepository.deleteByName(name);
    }

    @Transactional
    @Override
    public int increasePriceBy10Percent() {
        return ingredientRepository.increasePriceBy10Percent();
    }

    @Override
    @Transactional
    public int updateIngredientPriceByGivenNameAndPercent(String name, BigDecimal percent) {
        return ingredientRepository.updateIngredientPriceByGivenNameAndPercent(name, percent);
    }
}
