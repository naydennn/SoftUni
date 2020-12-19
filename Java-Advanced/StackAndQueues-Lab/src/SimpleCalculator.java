import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split("\\s+");
        for (int i = numbers.length -1; i >=0 ; i--) {
            stack.push(numbers[i]);
        }
        int result;
        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    stack.push(String.valueOf(result));
                break;
                case "-":
                    result = firstNum - secondNum;
                    stack.push(String.valueOf(result));
                break;
            }
        }
        System.out.println(stack.pop());
    }
}
