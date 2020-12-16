import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] commands = input.split(">>>");

            switch (commands[0]) {
                case "Contains":
                    String substring = commands[1];
                    if (key.contains(substring)) {
                        System.out.println(key + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String token = commands[1];
                    int startIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);
                    String stringToChange = key.substring(startIndex, endIndex);
                    String changedString;
                    if (token.equals("Upper")) {
                        changedString = stringToChange.toUpperCase();
                    } else {
                        changedString = stringToChange.toLowerCase();
                    }
                    key = key.replace(stringToChange, changedString);
                    System.out.println(key);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    String stringToDelete = key.substring(startIndex, endIndex);
                    key = key.replace(stringToDelete, "");
                    System.out.println(key);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + key);
    }
}
