package vehiclesExtended;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]),
                Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]),
                Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");

        Bus bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]),
                Double.parseDouble(busInfo[3]));

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            try {
                switch (tokens[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            System.out.println(car.driving(distance));
                        } else if (tokens[1].equals("Truck")) {
                            System.out.println(truck.driving(distance));
                        } else {
                            Bus.IS_EMPTY = true;
                            System.out.println(bus.driving(distance));
                        }
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(tokens[2]);
                        if (tokens[1].equals("Car")) {
                            car.refueling(liters);
                        } else if (tokens[1].equals("Truck")) {
                            truck.refueling(liters);
                        } else {
                            bus.refueling(liters);
                        }
                        break;
                    case "DriveEmpty":
                        Bus.IS_EMPTY = false;
                        distance = Double.parseDouble(tokens[2]);
                        System.out.println(bus.driving(distance));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
