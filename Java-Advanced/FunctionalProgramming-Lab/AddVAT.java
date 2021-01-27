import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble)
                .toArray();
        Function<Double, Double> getPriceWithVat = d -> d * 1.2;

        System.out.println("Prices with VAT:");
        for (double d :numbers) {
            System.out.printf("%.2f%n", getPriceWithVat.apply(d));
        }
    }
}
