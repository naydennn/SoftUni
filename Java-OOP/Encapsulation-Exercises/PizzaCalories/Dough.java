package PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> flourTypes = Map.of(
            "White" , 1.5,
            "Wholegrain", 1.0
    );
    private static final Map<String, Double> bakingTechniques = Map.of(
            "Crispy" , 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0
    );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setWeight(weight);
        setBakingTechnique(bakingTechnique);
        setFlourType(flourType);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    private void setFlourType(String flourType) {
        if (!flourTypes.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }
    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechniques.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return (2 * this.weight) * bakingTechniques.get(this.bakingTechnique)
                * flourTypes.get(this.flourType);
    }
}
