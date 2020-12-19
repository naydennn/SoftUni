import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '(') {
                stack.push(i);
            }else if (symbol == ')') {
                endIndex = i;
                System.out.println(expression.substring(stack.pop(), endIndex + 1));

            }
        }
    }
}
