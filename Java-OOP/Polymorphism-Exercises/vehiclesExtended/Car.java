package vehicles;

public class Car extends Vehicle{

    public static final double CAR_INCREASE_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CAR_INCREASE_PER_KM, tankCapacity);
    }

    @Override
    public String driving(double distance) {
        return "Car " + super.driving(distance);
    }

    @Override
     public void refueling(double liters) {
        super.refueling(liters);
    }

    @Override
    public String toString() {
        return String.format("%s%.2f",super.toString(), this.getFuelQuantity());
    }
}
