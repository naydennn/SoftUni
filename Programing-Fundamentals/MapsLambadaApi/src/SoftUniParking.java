
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n  = Integer.parseInt(scanner.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String user = commands[1];
            switch (commands[0]) {
                case "register":
                    String plateNumber = commands[2];
                    if (!users.containsKey(user)) {
                        users.put(user, plateNumber);
                        System.out.printf("%s registered %s successfully%n", user, plateNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n", user);
                    } else {
                        users.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }
                    break;
            }
        }
        users.forEach((key, value) -> System.out.println(key + " => " + value));

    }
}
