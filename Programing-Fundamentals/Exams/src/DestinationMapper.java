import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<state>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> destination = new ArrayList<>();
        int points = 0;

        while (matcher.find()) {
            String state = matcher.group("state");
            for (int i = 0; i < state.length(); i++) {
                points++;
            }
            destination.add(state);
        }
        System.out.println("Destinations: " + String.join(", ", destination));
        System.out.println("Travel Points: " + points);

    }
}
