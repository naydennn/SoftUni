package vehiclesExtended;

public class Bus extends Vehicle{

    public static boolean IS_EMPTY = true;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        if (IS_EMPTY) {
            super.setFuelConsumption(fuelConsumption + 1.4);
        }
    }

    @Override
    public String driving(double distance) {
        return "Bus" + super.driving(distance);
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
