package canConstructor;

import java.util.Scanner;

public class CarInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car;
            if (tokens.length < 2) {
                car = new Car(tokens[0]);
            } else {
                car  = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            System.out.println(car.toString());
        }
    }
}
