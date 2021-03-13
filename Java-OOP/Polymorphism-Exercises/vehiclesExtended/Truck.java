package vehiclesExtended;


public class Truck extends Vehicle{

    public static final double TRUCK_INCREASE_PER_KM = 1.6;


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + TRUCK_INCREASE_PER_KM, tankCapacity);
    }

    @Override
    public String driving(double distance) {
       return "Truck " + super.driving(distance);
    }

    @Override
     public void refueling(double liters) {
        super.refueling(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("%s%.2f",super.toString(), this.getFuelQuantity());
    }
}
