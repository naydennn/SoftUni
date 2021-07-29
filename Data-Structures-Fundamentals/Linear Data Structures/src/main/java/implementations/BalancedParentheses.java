package implementations;

import interfaces.Solvable;

import java.util.ArrayDeque;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < this.parentheses.length(); i++) {
            char symbol = parentheses.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(String.valueOf(symbol));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();

                switch (symbol) {
                    case ')':
                        if (!pop.equals("(")) {
                            return false;
                        }
                        break;
                    case ']':
                        if (!pop.equals("[")) {
                            return false;
                        }
                        break;
                    case '}':
                        if (!pop.equals("{")) {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
