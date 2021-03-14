package wildFarm;

public class Mouse extends Mammal{
    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }
    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Meat) {
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
