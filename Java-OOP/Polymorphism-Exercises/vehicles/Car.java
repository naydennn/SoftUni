package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{

    public static final double CAR_INCREASE_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + CAR_INCREASE_PER_KM);
    }

    @Override
    void driving(double distance) {
        double result = getFuelQuantity() - (distance * getFuelConsumption());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (result < 0) {
            System.out.println("Car needs refueling");
        } else {
            super.setFuelQuantity(result);
            System.out.printf("Car travelled %s km%n", decimalFormat.format(distance));
        }
    }

    @Override
    void refueling(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s%.2f",super.toString(), this.getFuelQuantity());
    }
}
