package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String pattern);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    @Modifying
    int deleteByName(String name);

    @Query("update Ingredient set price = price * 1.10")
    @Modifying
    int increasePriceBy10Percent();

    @Query("update Ingredient i set i.price = i.price + i.price * :percent where i.name = :name")
    @Modifying
    int updateIngredientPriceByGivenNameAndPercent(String name, BigDecimal percent);
}
