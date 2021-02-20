package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return data.size();
    }

    public void add(Car car) {
        if (capacity > getCount()) {
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model) {

        for (Car car :data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar() {
       return data.stream().max(Comparator.comparingInt(Car::getYear)).orElseGet(null);
    }
    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(a->a.getManufacturer().equals(manufacturer) && a.getModel().equals(model)).findFirst().get();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(name).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
