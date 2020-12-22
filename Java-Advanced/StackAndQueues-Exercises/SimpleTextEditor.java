import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String token = commands[0];
            switch (token) {
                case "1":
                    stack.push(text);
                    text = text.concat(commands[1]);
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(commands[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    if (!stack.isEmpty()) {
                    text = stack.pop();
                    }
                    break;
            }
        }
    }
}
