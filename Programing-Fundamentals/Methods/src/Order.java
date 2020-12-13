import java.util.Scanner;

public class Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double priceOfProduct = Double.parseDouble(scanner.nextLine());

        calculatePriceOfProduct(product, priceOfProduct);
    }

    public static void calculatePriceOfProduct(String product, double priceOfProduct) {
        switch (product) {
            case "coffee":
                priceOfProduct *= 1.5;
                break;
            case "water":
                priceOfProduct *= 1;
                break;
            case "coke":
                priceOfProduct *= 1.4;
                break;
            case "snacks":
                priceOfProduct *= 2;
                break;
        }
        System.out.printf("%.2f", priceOfProduct);
    }
}
