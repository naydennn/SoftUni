import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> usersEmails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            int index = email.indexOf(".");
            String domain = email.substring(index + 1);
            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                usersEmails.put(name, email);
            }
            name = scanner.nextLine();
        }
        usersEmails.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
