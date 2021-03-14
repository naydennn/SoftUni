package wildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    " are not eating that type of food!");
        }
        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                this.getClass().getSimpleName(),
                super.toString());
    }
}
