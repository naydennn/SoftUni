package SpeedRacing;

public class Car {
    private static int km = 0;
    private String model;
    private double fuelAmount;
    private double amountOfKm;
    private int distance;

    public Car(String model, double fuelAmount, double amountOfKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.amountOfKm = amountOfKm;
        this.distance = 0;
    }
    public boolean driveCar(int km) {
        double needFuel = km * this.amountOfKm;
        if (needFuel <= this.fuelAmount) {
            this.fuelAmount -= needFuel;
            distance += km;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, distance);
    }
}


