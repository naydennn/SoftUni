import java.nio.charset.IllegalCharsetNameException;
import java.util.Scanner;

public class e01_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double change = 0;
        double totalPrice = 0;
        double sum = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 2 || coins == 1 || coins == 0.5 || coins == 0.2 || coins == 0.1) {
                sum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            input = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            boolean isPrint = true;
            double price = 0;
            switch (product) {
                case "Nuts":
                    price = 2;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1;
                    break;
                default:
                    isPrint = false;
                    break;
            }
            totalPrice += price;

            if (sum >= totalPrice && isPrint) {
                System.out.printf("Purchased %s%n", product);
                change += price;
            } else if (sum < totalPrice && isPrint) {
                totalPrice -= price;
                System.out.println("Sorry, not enough money");
            } else {
                System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        totalPrice = Math.abs(change - sum);
        System.out.printf("Change: %.2f", totalPrice);
    }
}
