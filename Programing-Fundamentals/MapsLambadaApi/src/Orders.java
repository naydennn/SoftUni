import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> nameAndPrice = new LinkedHashMap<>();
        Map<String, Double> nameAndQuantity = new LinkedHashMap<>();
        Map<String, Double> finalOrder = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] commands = input.split(" ");
            String nameOfProduct = commands[0];
            double price = Double.parseDouble(commands[1]);
            double quantity = Double.parseDouble(commands[2]);

            if (nameAndQuantity.get(nameOfProduct) == null && nameAndPrice.get(nameOfProduct) == null) {
                nameAndQuantity.put(nameOfProduct, quantity);
                nameAndPrice.put(nameOfProduct, price);

            } else {
                nameAndPrice.put(nameOfProduct, price);
                nameAndQuantity.put(nameOfProduct, nameAndQuantity.get(nameOfProduct) + quantity);
            }
            finalOrder.put(nameOfProduct, nameAndPrice.get(nameOfProduct) * nameAndQuantity.get(nameOfProduct));
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : finalOrder.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue());
        }

    }
}
