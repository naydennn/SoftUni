package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setHorsePower(int horsePower) {
        if (this.getClass().getSimpleName().equals("MuscleCar")) {
            if (horsePower < 400 || horsePower > 600) {
                throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
            }
        } else if (this.getClass().getSimpleName().equals("SportsCar")) {
            if (horsePower < 250 || horsePower > 450) {
                throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
            }
        }
        this.horsePower = horsePower;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / horsePower * laps;
    }
}
