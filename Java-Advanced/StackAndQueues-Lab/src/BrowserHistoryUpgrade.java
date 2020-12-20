import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String currentPage = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!command.equals("Home")) {
            switch (command) {
                case "back":
                    if (stack.isEmpty()) {
                        System.out.println("no previous URLs");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        forward.push(currentPage);
                        currentPage = stack.pop();

                    }
                    break;
                case "forward":
                    if (forward.isEmpty()) {
                        System.out.println("no next URLs");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        stack.push(currentPage);
                        currentPage = forward.pop();
                    }
                    break;
                default:
                    if (!currentPage.isEmpty()) {
                        stack.push(currentPage);
                    }
                    forward.clear();
                    currentPage = command;
                    break;
            }

            System.out.println(currentPage);
            command = scanner.nextLine();
        }
    }
}
