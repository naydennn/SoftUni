import java.util.Scanner;

public class L02_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = scanner.nextDouble();

        double dollars = pounds * 1.31;

        System.out.printf("%.3f", dollars);
    }
}
