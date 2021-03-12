package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity + this.fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String driving(double distance) {
        double result = getFuelQuantity() - (distance * getFuelConsumption());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (result < 0) {
            return "needs refueling";
        } else {
            setFuelQuantity(result);
            return String.format(" travelled %s km", decimalFormat.format(distance));
        }
    }

    public void refueling(double liters){
            if (liters > this.getTankCapacity()) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                setFuelQuantity(liters);
            }
    }

    @Override
    public String toString() {
        return String.format("%s: ", this.getClass().getSimpleName());
    }
}
