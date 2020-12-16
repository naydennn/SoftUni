import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");
            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    message = message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = commands[1];
                    if (message.toString().contains(substring)) {
                        int indexOf = message.indexOf(substring);
                        message.delete(indexOf, indexOf + substring.length());
                        StringBuilder reverseSubstring = new StringBuilder();
                        for (int i = 0; i < substring.length(); i++) {
                            reverseSubstring.append(substring.charAt(substring.length() - i - 1));
                        }
                        message.append(reverseSubstring);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = commands[1];
                    String replacement = commands[2];
                    while (message.toString().contains(substring)) {
                        index = message.indexOf(substring);
                        message.replace(index, index + 1, replacement);
                    }
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);

    }
}
