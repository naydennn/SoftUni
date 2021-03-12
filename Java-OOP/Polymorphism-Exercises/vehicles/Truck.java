package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public static final double TRUCK_INCREASE_PER_KM = 1.6;


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + TRUCK_INCREASE_PER_KM);
    }

    @Override
    void driving(double distance) {
        double result = getFuelQuantity() - (distance * getFuelConsumption());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (result < 0) {
            System.out.println("Truck needs refueling");
        } else {
            super.setFuelQuantity(result);
            System.out.printf("Truck travelled %s km%n", decimalFormat.format(distance));
        }
    }

    @Override
    void refueling(double liters) {
        double maxRefuel = liters - (liters * 0.05);

        setFuelQuantity(getFuelQuantity() + maxRefuel);
    }

    @Override
    public String toString() {
        return String.format("%s%.2f",super.toString(), this.getFuelQuantity());
    }
}
