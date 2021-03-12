package vehicles;

public class Bus extends Vehicle{

    public static final boolean IS_EMPTY = false;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
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
