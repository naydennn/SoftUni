package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int countOfToppings) {
        if (countOfToppings < 0 || countOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(countOfToppings);
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public double getOverallCalories() {
        double calories = 0;
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        calories += dough.calculateCalories();

        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name , getOverallCalories());
    }
}
