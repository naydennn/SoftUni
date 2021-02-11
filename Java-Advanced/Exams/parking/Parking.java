package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return data.size();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufactures, String model) {
      return data.removeIf(car -> car.getManufacturer().equals(manufactures) && car.getModel().equals(model));
    }
    public Car getLatestCar() {
        if (!data.isEmpty()) {
            return data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
        return null;
    }
    public Car getCar(String manufactures, String model) {
        if (!data.isEmpty()) {
           return data.stream().filter(a-> a.getManufacturer().equals(manufactures) && a.getModel().equals(model)).findFirst().get();
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }

        return String.valueOf(sb);
    }
}
