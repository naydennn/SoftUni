import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] commands = input.split(", ");
            String shop = commands[0];
            String product = commands[1];
            double price = Double.parseDouble(commands[2]);

            Map<String, Double> productInfo = shops.get(shop);
            if (productInfo == null) {
                productInfo = new LinkedHashMap<>();
                shops.put(shop, productInfo);
            }
            productInfo.put(product, price);
            shops.put(shop, productInfo);

            input = scanner.nextLine();
        }
        shops.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((key1, value1) -> System.out.printf("Product: %s, Price: %.1f%n", key1, value1));
        });
    }
}
