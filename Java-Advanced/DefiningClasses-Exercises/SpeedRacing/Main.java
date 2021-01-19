package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            Car car = new Car(model, Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            cars.put(model, car);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            Car carToDrive = cars.get(model);
            if (!carToDrive.driveCar(amountOfKm)) {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }
        for (Car car :
                cars.values()) {
            System.out.println(car.toString());
        }
    }
}
