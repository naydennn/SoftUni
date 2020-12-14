import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> planets = new TreeMap<>();
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        planets.put("Attacked planets",attackedPlanets);
        planets.put("Destroyed planets",destroyedPlanets);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String sb = scanner.nextLine();

            int countToDelete = countToDelete(sb);
            StringBuilder result = new StringBuilder();

            getStringToUse(sb, countToDelete, result);

            Pattern pattern = Pattern.compile("(?<planet>[A-Z][a-z]+)(?:[^@\\-!:>]*):(?<population>(\\d)+)+(?:[^@\\-!:>]*)!(?<type>[AD])!(?:[^@\\-!:>]*)->(?<soldierCount>\\d+)");
            Matcher matcher = pattern.matcher(result);




            while (matcher.find()) {
                String type = matcher.group("type");
                String planet = matcher.group("planet");
                switch (type) {
                    case "A" -> {
                        attackedPlanets.add(planet);
                        planets.put("Attacked planets", attackedPlanets);
                    }
                    case "D" -> {
                        destroyedPlanets.add(planet);
                        planets.put("Destroyed planets", destroyedPlanets);
                    }
                }
            }
        }
        planets.forEach((key, value) -> {
            System.out.println(key + ": " + value.size());
            value.stream().sorted(String::compareTo).
                    filter(b -> b.length() > 0).forEach(b -> System.out.println("-> " + b));
        });
    }

    private static void getStringToUse(String sb, int countToDelete, StringBuilder result) {
        for (int j = 0; j < sb.length(); j++) {
            result.append((char) (sb.charAt(j) - countToDelete));
        }
    }

    private static int countToDelete(String sb) {
        int countToDelete = 0;
        for (int j = 0; j < sb.length(); j++) {
            char symbol = sb.charAt(j);
            if (symbol == 's' || symbol == 't' ||
                    symbol == 'a' || symbol == 'r' || symbol == 'S'
                    || symbol == 'T' || symbol == 'A' || symbol == 'R') {
                countToDelete++;
            }
        }
        return countToDelete;
    }
}
