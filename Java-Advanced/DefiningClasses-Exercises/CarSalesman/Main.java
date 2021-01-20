package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;

            if (tokens.length == 2) {
                engine = new Engine(model,power);
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];

            Car car;
            if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }else {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            }
            cars.add(car);
        }
        for (Car car :
                cars) {
            System.out.println(car.getModel() + ":");
            for (Engine engine: engines) {
                if (car.getEngine().equals(engine.getModel())) {
                    System.out.println(engine.getModel() + ":");
                    System.out.println("Power: " + engine.getPower());
                    if (engine.getDisplacement() != 0) {
                        System.out.println("Displacement: " + engine.getDisplacement());
                    } else {
                        System.out.println("Displacement: n/a");
                    }
                    System.out.println("Efficiency: " + engine.getEfficiency());
                }
            }
            if (car.getWeight() != 0) {
                System.out.println("Weight: " + car.getWeight());
            } else {
                System.out.println("Weight: n/a");
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
