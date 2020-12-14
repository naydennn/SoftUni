import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<Character, Integer> countOfCharacters = new LinkedHashMap<>();
        for (int i = 0; i <words.length ; i++) {
            String word = words[i];
            for (int j = 0; j <word.length() ; j++) {
                char character = word.charAt(j);
                if (!countOfCharacters.containsKey(character)) {
                    countOfCharacters.put(character,1);
                } else {
                    countOfCharacters.put(character, countOfCharacters.get(character) + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : countOfCharacters.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
