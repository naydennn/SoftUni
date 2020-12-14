import java.math.BigDecimal;
import java.util.Scanner;

public class L02_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 1; i <= count ; i++) {
            String input = scanner.nextLine();
            BigDecimal number = new BigDecimal(input);
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}
