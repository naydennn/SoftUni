
import java.util.*;

public class SoftUniExamResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> result = new TreeMap<>();
        Map<String, Integer> submission = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String[] commands = input.split("-");
            String name = commands[0];

            if ("banned".equals(commands[1])) {
                result.remove(name);
            } else {
                String language = commands[1];
                int point = Integer.parseInt(commands[2]);

                submission.putIfAbsent(language, 0);
                submission.put(language, submission.get(language) + 1);


                result.putIfAbsent(name, point);

                if (result.get(name) < point) {
                    result.put(name, point);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        result.entrySet().stream().sorted((a,b) -> b.getValue() - a.getValue()).forEach(a -> System.out.println(a.getKey() + " | " + a.getValue()));
        System.out.println("Submissions:");
        submission.entrySet().stream().sorted((a,b) -> b.getValue() - a.getValue()).forEach(a-> System.out.println(a.getKey() + " - " + a.getValue()));
    }
}
