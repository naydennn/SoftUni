import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carAndMileage = new TreeMap<>();
        Map<String, Integer> carAndFuel = new TreeMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] cars = scanner.nextLine().split("\\|");
            carAndMileage.putIfAbsent(cars[0], Integer.parseInt(cars[1]));
            carAndFuel.putIfAbsent(cars[0], Integer.parseInt(cars[2]));
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commands = input.split(" : ");
            String car = commands[1];
            switch (commands[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);
                    if (carAndFuel.get(car) >= fuel) {
                        carAndFuel.put(car, carAndFuel.get(car) - fuel);
                        carAndMileage.put(car, carAndMileage.get(car) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (carAndMileage.get(car) >= 100000) {
                            carAndFuel.remove(car);
                            carAndMileage.remove(car);
                            System.out.println("Time to sell the " + car + "!");
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(commands[2]);
                    if (carAndFuel.get(car) + fuel > 75) {
                        int refueled = 75 - carAndFuel.get(car);
                        carAndFuel.put(car, 75);
                        System.out.printf("%s refueled with %d liters%n", car, refueled);
                    } else {
                        carAndFuel.put(car, carAndFuel.get(car) + fuel);
                        System.out.printf("%s refueled with %d liters%n", car, fuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    if (carAndMileage.get(car) - kilometers < 10000) {
                        carAndMileage.put(car, 10000);
                    } else {
                        carAndMileage.put(car, carAndMileage.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;

            }
            input = scanner.nextLine();
        }
        carAndMileage.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", a.getKey(), a.getValue(), carAndFuel.get(a.getKey())));
    }
}
