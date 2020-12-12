import com.sun.jdi.DoubleValue;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = 0;
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double totalProduct = Double.parseDouble(scanner.nextLine());

        if (product.equals("coffee") && city.equals("Sofia")) {
            price = totalProduct * 0.5;
        } else if (product.equals("coffee") && city.equals("Plovdiv")) {
            price = totalProduct * 0.4;
        } else if (product.equals("coffee") && city.equals("Varna")) {
            price = totalProduct * 0.45;
        }

        if (product.equals("water") && city.equals("Sofia")) {
            price = totalProduct * 0.8;
        } else if (product.equals("water") && city.equals("Plovdiv")) {
            price = totalProduct * 0.7;
        } else if (product.equals("water") && city.equals("Varna")) {
            price = totalProduct * 0.7;
        }

        if (product.equals("beer") && city.equals("Sofia")) {
            price = totalProduct * 1.2;
        } else if (product.equals("beer") && city.equals("Plovdiv")) {
            price = totalProduct * 1.15;
        } else if (product.equals("beer") && city.equals("Varna")) {
            price = totalProduct * 1.1;
        }

        if (product.equals("sweets") && city.equals("Sofia")) {
            price = totalProduct * 1.45;
        } else if (product.equals("sweets") && city.equals("Plovdiv")) {
            price = totalProduct * 1.3;
        } else if (product.equals("sweets") && city.equals("Varna")) {
            price = totalProduct * 1.35;
        }

        if (product.equals("peanuts") && city.equals("Sofia")) {
            price = totalProduct * 1.6;
        } else if (product.equals("peanuts") && city.equals("Plovdiv")) {
            price = totalProduct * 1.5;
        } else if (product.equals("peanuts") && city.equals("Varna")) {
            price = totalProduct * 1.55;
        }

        System.out.println(price);

   }
}
