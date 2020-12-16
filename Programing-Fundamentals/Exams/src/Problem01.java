
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Sign up")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Case":
                    String lowerOrUpper = commands[1];
                    if (lowerOrUpper.equals("lower")) {
                        username = username.toLowerCase();
                    } else {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >= 0 && endIndex < username.length()) {
                        String substringToReverse = username.substring(startIndex, endIndex+1);
                        StringBuilder sb = new StringBuilder(substringToReverse).reverse();
                        System.out.println(sb.toString());
                    }
                    break;
                case "Cut":
                    String substring = commands[1];
                    if (username.contains(substring)) {
                        int index = username.indexOf(substring);
                        String first = username.substring(0, index);
                        String second = username.substring(index + substring.length());
                        username = first + second;
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                    }
                    break;
                case "Replace":
                    String symbolToReplace = commands[1];
                    username = username.replaceAll(symbolToReplace, "*");
                    System.out.println(username);
                    break;
                case "Check":
                    String symbolToCheck = commands[1];
                    if (username.contains(symbolToCheck)) {
                        System.out.println("Valid");
                    }else {
                        System.out.println("Your username must contain " + symbolToCheck + ".");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
