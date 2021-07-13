package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

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
}
