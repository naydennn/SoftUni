import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacter {
    public static void main(String[] args) throws IOException {

        Path inPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");


        BufferedReader bufferedReader = Files.newBufferedReader(inPath);
        String line = bufferedReader.readLine();
        String vowels = "aeiou";
        String punctuation = "!.?,";
        int vowelsCount = 0;
        int othersCount = 0;
        int punctuations = 0;
        while (!(line == null)) {
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (symbol == 10 || symbol == 32) {
                    continue;
                } else if (vowels.contains(String.valueOf(symbol))) {
                    vowelsCount++;
                } else if (punctuation.contains(String.valueOf(symbol))) {
                    punctuations++;
                } else {
                    othersCount++;
                }
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        PrintWriter printWriter = new PrintWriter("output.txt");
        printWriter.println("Vowels: " + vowelsCount);
        printWriter.println("Consonants: " + othersCount);
        printWriter.println("Punctuation: " + punctuations);
        printWriter.close();
    }
}
