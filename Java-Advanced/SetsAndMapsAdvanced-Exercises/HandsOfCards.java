import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> decks = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            int index = input.lastIndexOf(":");
            String name = input.substring(0, index);
            List<String> cards = Arrays.stream(input.substring(index + 2).split(",\\s+"))
                    .collect(Collectors.toList());

            decks.putIfAbsent(name, new HashSet<>());
            decks.get(name).addAll(cards);

            input = scanner.nextLine();
        }
        decks.forEach((key, value) -> {
            int totalPoints = 0;
            for (String card : value) {

                String powerOfCard;
                char typeOfCard;
                if (card.length() > 2) {
                    powerOfCard = String.valueOf(card.charAt(0));
                    powerOfCard += String.valueOf(card.charAt(1));
                    typeOfCard = card.charAt(2);
                } else {
                    powerOfCard = String.valueOf(card.charAt(0));
                    typeOfCard = card.charAt(1);
                }
                int points = getPowerOfCard(powerOfCard);
                switch (typeOfCard) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                    case 'C':
                        points *= 1;
                        break;
                }
                totalPoints += points;
            }
            System.out.println(key + ": " + totalPoints);
        });
    }

    private static int getPowerOfCard(String powerOfCard) {
        int points;
        if ("J".equals(powerOfCard)) {
            points = 11;
        } else if ("Q".equals(powerOfCard)) {
            points = 12;
        } else if ("K".equals(powerOfCard)) {
            points = 13;
        } else if ("A".equals(powerOfCard)) {
            points = 14;
        } else {
            points = Integer.parseInt(powerOfCard);
        }
        return points;
    }
}
