import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char openSymbol = input.charAt(i);
            if (openSymbol == '[' || openSymbol == '(' || openSymbol == '{') {
                stack.push(openSymbol);
            } else if (openSymbol == ']' || openSymbol == ')' || openSymbol == '}') {
                if (!stack.isEmpty()) {
                    if (openSymbol == ']' && stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    } else if (openSymbol == ')' && stack.pop() != '(') {
                        isBalanced = false;
                        break;

                    } else if (openSymbol == '}' && stack.pop() != '{') {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
