package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long price);

    List<Shampoo> findAllByPriceIsGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceIsLessThan(BigDecimal price);

    @Query("select s from Shampoo s join s.ingredients i where i.name in :ingredientNames")
    List<Shampoo> getAllShampooWithGivenIngredient(List<String> ingredientNames);

    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :value")
    List<Shampoo> getAllShampooByIngredientCount(Integer value);
}
