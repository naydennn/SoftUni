package CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        Car car;
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length == 1){
                car = new Car(data[0]);

            } else {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            }
            carList.add(car);
        }

        for (Car car1 : carList) {
            System.out.println(car1.toString());
        }

    }
}
