import java.util.Scanner;

public class SecretChatWithString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");
            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    StringBuilder sb = new StringBuilder(message);
                    sb.insert(index, " ");
                    message = sb.toString();
                    System.out.println(message);

                    break;
                case "Reverse":
                    String substring = commands[1];
                    index = message.indexOf(substring);
                    if (message.contains(substring)) {
                        sb = new StringBuilder(message);
                        sb.replace(index, index + substring.length(), "");
                        message = sb.toString();
                        StringBuilder reverseSubstring = new StringBuilder(substring).reverse();
                        message = message.concat(reverseSubstring.toString());
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = commands[1];
                    String replacement = commands[2];
                    message = message.replaceAll(substring, replacement);
                    System.out.println(message);
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
