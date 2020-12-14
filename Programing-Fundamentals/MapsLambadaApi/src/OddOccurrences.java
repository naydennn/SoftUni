import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> elements = new LinkedHashMap<>();

        for (String word:words) {
            String wordInLowerCase = word.toLowerCase();
            if (!elements.containsKey(wordInLowerCase)) {
                elements.put(wordInLowerCase, 1);
            } else {
                elements.put(wordInLowerCase, elements.get(wordInLowerCase) + 1);
            }
        }
        List<String> oddElement = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : elements.entrySet()) {
            if (entry.getValue() % 2 !=0) {
                oddElement.add(entry.getKey());
            }
        }
        for (int i = 0; i <oddElement.size() ; i++) {
            System.out.print(oddElement.get(i));
            if (i <oddElement.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
