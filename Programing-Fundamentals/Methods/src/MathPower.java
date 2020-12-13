import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        double result = calculatePowerOfNumber(firstNum, secondNum);
        System.out.printf(new DecimalFormat("0.####").format(result));
    }
    public static double calculatePowerOfNumber(double first, double second) {
        double result = Math.pow(first, second);
        return result;
    }
}
