import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    public static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1),
                    getModel(), getColor(), getHorsepower());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> listOfVehicle = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] commands = input.split(" ");
            Vehicle vehicle = new Vehicle(commands[0], commands[1], commands[2], Integer.parseInt(commands[3]));
            listOfVehicle.add(vehicle);

            input = scanner.nextLine();
        }

        String printVehicle = scanner.nextLine();
        while (!printVehicle.equals("Close the Catalogue")) {

            String finalPrintVehicle = printVehicle;
            listOfVehicle.stream().filter(p -> p.getModel().equals(finalPrintVehicle)).forEach(vehicle -> System.out.println(vehicle));
            printVehicle = scanner.nextLine();
        }

        List<Vehicle> car = listOfVehicle.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> truck = listOfVehicle.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());
        System.out.printf("Cars have average horsepower of: %.2f.%n" ,getAverageHorsePower(car));
        System.out.printf("Trucks have average horsepower of: %.2f." ,getAverageHorsePower(truck));
    }

    private static double getAverageHorsePower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        return vehicles.stream().mapToDouble(Vehicle::getHorsepower).sum()/vehicles.size();
    }

}
