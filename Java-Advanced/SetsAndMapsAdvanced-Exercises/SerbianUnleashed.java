import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> singers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = scanner.nextLine();
                continue;
            }
            String[] check = input.split("\\s+");
            if (check.length > 3) {
                int indexOfName = input.indexOf("@");
                int indexOfCity = getIndexOfDigit(input);
                if (indexOfCity == 0) {
                    input = scanner.nextLine();
                    continue;
                }
                String name = input.substring(0, indexOfName);
                String city = input.substring(indexOfName + 1, indexOfCity);
                String[] values = input.substring(indexOfCity).split("\\s+");
                if (values.length != 2) {
                    input = scanner.nextLine();
                    continue;
                }
                long totalMoney = Long.parseLong(values[0]) * Long.parseLong(values[1]);

                if (!singers.containsKey(city)) {
                    singers.put(city, new LinkedHashMap<>());
                }
                if (!singers.get(city).containsKey(name)) {
                    singers.get(city).put(name, 0L);
                }
                singers.get(city).put(name, singers.get(city).get(name) + totalMoney);
            }


            input = scanner.nextLine();
        }
        singers.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(c -> System.out.println("#  " + c.getKey() + "-> " + c.getValue()));
        });
    }

    private static int getIndexOfDigit(String input) {
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol) && input.charAt(i - 1) == ' ') {
                index = i;
                break;
            }
        }
        return index;
    }
}
