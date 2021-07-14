package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientServices;
import com.example.advquerying.services.ShampooServices;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ShampooServices shampooServices;
    private final IngredientServices ingredientServices;

    public CommandLineRunner(ShampooServices shampooServices, IngredientServices ingredientServices) {
        this.shampooServices = shampooServices;
        this.ingredientServices = ingredientServices;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please choose exercise number:");
        int numOfEx = Integer.parseInt(sc.nextLine());
        switch (numOfEx) {
            case 1 -> ex1();
            case 2 -> ex2();
            case 3 -> ex3();
            case 4 -> ex4();
            case 5 -> ex5();
            case 6 -> ex6();
            case 7 -> ex7();
            case 8 -> ex8();
            case 9 -> ex9();
            case 10 -> ex10();
            case 11 -> ex11();
        }
    }

    private void ex11() {

    }

    private void ex10() {
        System.out.println("Updated rows: "+ ingredientServices.increasePriceBy10Percent());
    }

    private void ex9() {
        System.out.println(ingredientServices.deleteByName("Herbs"));
    }

    private void ex8() {
        shampooServices.getAllShampooByIngredientCount(2)
                .forEach(System.out::println);
    }

    private void ex7() {
        shampooServices.getAllShampooWithGivenIngredient(Arrays.asList("Berry", "Mineral-Collagen"))
                .forEach(System.out::println);
    }

    private void ex6() {
        System.out.println(shampooServices.countAllByPriceIsLessThan(new BigDecimal("8.50")));
    }

    private void ex5() {
        ingredientServices.findAllByNameInOrderByPrice(Arrays.asList("Lavender", "Herbs", "Apple"))
                .stream()
                .map(Ingredient::getName)
                .forEach(System.out::println);
    }

    private void ex4() {
        ingredientServices.findAllByNameStartingWith("M")
                .forEach(System.out::println);
    }

    private void ex3() {
        shampooServices.findAllByPriceIsGreaterThanOrderByPriceDesc(new BigDecimal(5))
                .forEach(System.out::println);
    }

    private void ex2() {
        shampooServices.findAllBySizeOrLabel_IdOrderByPrice(Size.valueOf("MEDIUM"), 10L)
                .forEach(System.out::println);
    }

    private void ex1() {
        shampooServices.findAllBySizeOrderById(Size.valueOf("MEDIUM"))
                .forEach(System.out::println);
    }
}
