import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split("\\s+");
            String ip = commands[0];
            String user = commands[2];
            int indexOfIp = ip.indexOf("=");
            int indexOfUser = user.indexOf("=");
            user = user.substring(indexOfUser + 1);
            ip = ip.substring(indexOfIp + 1);

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
            }
            if (!users.get(user).containsKey(ip)) {
                users.get(user).put(ip, 0);
            }
            users.get(user).put(ip, users.get(user).get(ip) + 1);


            input = scanner.nextLine();
        }
        users.forEach((key, value) -> {
            List<String> ipRow = new ArrayList<>();
            System.out.println(key + ":");
            value.forEach((key1, value1) -> ipRow.add(key1 + " => " + value1));
            for (int i = 0; i < ipRow.size(); i++) {
                if (i < ipRow.size() - 1) {
                    System.out.print(ipRow.get(i) + ", ");
                } else {
                    System.out.print(ipRow.get(i) + ".");
                    System.out.println();
                }
            }
        });
    }
}
