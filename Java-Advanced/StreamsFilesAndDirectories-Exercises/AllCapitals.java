import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        BufferedReader bufferedReader = Files.newBufferedReader(inPath);
        PrintWriter printWriter = new PrintWriter("output.txt");
        String line = bufferedReader.readLine();

        while (!(line == null)) {
            for (int i = 0; i < line.length(); i++) {
                    printWriter.write(line.toUpperCase(Locale.ROOT).charAt(i));
            }
            line = bufferedReader.readLine();
            printWriter.println();
        }
        bufferedReader.close();
        printWriter.close();
    }
}
