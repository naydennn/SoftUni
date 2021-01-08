import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersAndDuration = new TreeMap<>();
        Map<String, Set<String>> usersAndIp = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!usersAndIp.containsKey(user)) {
                usersAndDuration.put(user, 0);
                usersAndIp.put(user, new TreeSet<>());
            }
            usersAndIp.get(user).add(ip);
            usersAndDuration.put(user, usersAndDuration.get(user) + duration);
        }
        usersAndDuration.forEach((key, value) ->{
            System.out.print(key + ": "+ value);
            System.out.println(" [" + String.join(", ",usersAndIp.get(key)) + "]");
        });
    }
}
