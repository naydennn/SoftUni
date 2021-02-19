package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        String season = data[2].toUpperCase();
        String discountType = data[3];
        double result = PriceCalculator.calculate(Double.parseDouble(data[0]),
                Integer.parseInt(data[1]),
                Season.valueOf(season).getMultiplier(),
                Discount.valueOf(discountType).getDiscount());

        System.out.printf("%.2f", result);
    }
}
