package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]));

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        car.driving(distance);
                    }else {
                        truck.driving(distance);
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    if (tokens[1].equals("Car")) {
                        car.refueling(liters);
                    }else {
                        truck.refueling(liters);
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
