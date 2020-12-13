import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNum = Double.parseDouble(scanner.nextLine());

        double result = getResultOfOperation(firstNum, operator, secondNum);
        System.out.printf(new DecimalFormat("0.####").format(result));
    }
    public static double getResultOfOperation (double first, String operator, double second) {
        double result = 0;
        switch (operator){
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
        }
        return  result;
    }
}
