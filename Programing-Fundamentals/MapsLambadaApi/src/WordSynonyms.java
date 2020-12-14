import java.lang.reflect.Array;
import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i <n ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            List<String> synonyms = words.get(word);
            if (synonyms == null) {
                synonyms = new ArrayList<>();
                words.put(word, synonyms);
            }
            synonyms.add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            List<String> synonyms = entry.getValue();
            System.out.print(String.join(", ", synonyms));
            System.out.println();
        }

    }
}
