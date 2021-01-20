package RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            ArrayList<Tire> tyres = new ArrayList<>();
            Tire tyre = new Tire(Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7]), Integer.parseInt(tokens[8]),
                    Double.parseDouble(tokens[9]), Integer.parseInt(tokens[10]),
                    Double.parseDouble(tokens[11]), Integer.parseInt(tokens[12]));
            tyres.add(tyre);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tyres);
            cars.add(car);
        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (Car car:cars) {
                    if (car.getCargo().getCargoType().equals("fragile")); {
                        if (isValid(car)) {
                            System.out.println(car.getModel());
                        }
                    }
                }
            break;
            case "flamable":
                for (Car car :cars) {
                    int currPower = car.getEngine().getEnginePower();
                    if (currPower > 250) {
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }

    private static boolean isValid(Car car) {
        double tire1Pressure = car.getTires().get(0).getTire1Pressure();
        double tire2Pressure = car.getTires().get(0).getTire2Pressure();
        double tire3Pressure = car.getTires().get(0).getTire3Pressure();
        double tire4Pressure = car.getTires().get(0).getTire4Pressure();
        if (tire1Pressure < 1 || tire2Pressure < 1 || tire3Pressure < 1 || tire4Pressure < 1) {
            return true;
        }
        return false;
    }
}
