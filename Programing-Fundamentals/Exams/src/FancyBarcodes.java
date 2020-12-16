import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("[@][#]+(?<product>[A-Z][a-zA-Z\\d]{4,}[A-Z])([@][#]+)");

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            StringBuilder result = new StringBuilder();

            if (matcher.find()) {
                String product = matcher.group("product");
                for (int j = 0; j < product.length(); j++) {
                    char symbol = product.charAt(j);
                    if (Character.isDigit(symbol)) {
                        result.append(symbol);
                    }
                }
                if (result.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + result);
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
