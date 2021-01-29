import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Double":
                    List<String> namesToAdd = guests.stream().filter(getPredicate(tokens)).collect(Collectors.toList());
                    guests.addAll(namesToAdd);
                    Collections.sort(guests);
                    break;
                case "Remove":
                    guests.removeIf(getPredicate(tokens));
                    break;
            }
            input = scanner.nextLine();
        }
        if (!guests.isEmpty()) {
            System.out.print(String.join(", ", guests) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] tokens) {
        if (tokens[1].equals("StartsWith") || tokens[1].equals("EndsWith")) {
            String command = tokens[1];
            String filter = tokens[2];
            return command.equals("StartsWith") ? s -> s.startsWith(filter) :
                    s -> s.endsWith(filter);
        }
        int length = Integer.parseInt(tokens[2]);
        return n -> n.length() == length;
    }
}
