package vehiclesExtended;

import java.text.DecimalFormat;

public class Vehicle {

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
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
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
            return " needs refueling";
        } else {
            setFuelQuantity(result);
            return String.format(" travelled %s km", decimalFormat.format(distance));
        }
    }

    public void refueling(double liters){
        if (Validator.validNumber(liters)) {
            if (liters > this.getTankCapacity()) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                setFuelQuantity(liters + this.fuelQuantity);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: ", this.getClass().getSimpleName());
    }
}
