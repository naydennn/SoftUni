import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");
        Map<String, Integer> hashmap = new LinkedHashMap<>();

        for (String s : names) {
            hashmap.put(s, 0);
        }

        String regexName = "(?<name>[A-Za-z]+)";
        String regexScore = "(?<score>[\\d])";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternScore = Pattern.compile(regexScore);


        String input = scanner.nextLine();
        while (!input.equals("end of race")) {

            StringBuilder name = new StringBuilder();
            int score = 0;

            Matcher matcherName = patternName.matcher(input);
            while (matcherName.find()) {
                name.append(matcherName.group(0));
            }
            Matcher matcherScore = patternScore.matcher(input);
            while (matcherScore.find()) {
                score += Integer.parseInt(matcherScore.group(0));
            }

            if (hashmap.containsKey(name.toString())) {
                hashmap.put(name.toString(), hashmap.get(name.toString()) + score);
            }
            input = scanner.nextLine();
        }

        List<String> orderedNames = new ArrayList<>();

        hashmap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3).forEach(a -> orderedNames.add(a.getKey()));

        System.out.printf("1st place: %s%n", orderedNames.get(0));
        System.out.printf("2nd place: %s%n", orderedNames.get(1));
        System.out.printf("3rd place: %s%n", orderedNames.get(2));
    }
}
