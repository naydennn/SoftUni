import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] commands = input.split("-");
            String name = commands[0];
            String number = commands[1];

            phonebook.putIfAbsent(name, number);
            if (phonebook.containsKey(name)) {
                phonebook.put(name, number);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }

            input = scanner.nextLine();
        }

    }
}
