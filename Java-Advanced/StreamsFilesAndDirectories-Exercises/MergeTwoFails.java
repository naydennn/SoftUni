import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFails {
    public static void main(String[] args) throws IOException {

        Path firstPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> firstText = Files.readAllLines(firstPath);
        List<String> secondText = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("output.txt");

        for (String s : firstText) {
            writer.println(s);
        }
        for (String s : secondText) {
            writer.println(s);
        }
        writer.close();

    }
}
