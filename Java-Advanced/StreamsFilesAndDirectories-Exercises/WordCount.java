import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> listOfStrings = new LinkedHashMap<>();

        Path firstPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path secondPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        List<String> firstText = Files.readAllLines(firstPath);
        List<String> secondText = Files.readAllLines(secondPath);

        String[] firstWords = getArray(firstText);
        String[] secondWords = getArray(secondText);

        for (int i = 0; i < firstWords.length; i++) {
            String currentWord = firstWords[i];
            for (int j = 0; j < secondWords.length; j++) {
                String currWord = secondWords[j];
                if (currentWord.equals(currWord)) {
                    listOfStrings.putIfAbsent(currWord, 0);
                    listOfStrings.put(currWord, listOfStrings.get(currWord) + 1);
                }
            }
        }


        listOfStrings.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a -> System.out.println(a.getKey() + " - " + a.getValue()));
    }

    private static String[] getArray(List<String> firstText) {
        return firstText.get(0).split("\\s+");
    }
}
