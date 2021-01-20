package RawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private ArrayList<Tire> tires;

    public Car (String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, ArrayList<Tire> tires) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Tire> getTires() {
        return tires;
    }
}
