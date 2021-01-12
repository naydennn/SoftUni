import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) throws IOException {


        Path firstPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");

        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(firstPath)));
        String line = reader.readLine();
        PrintWriter writer = new PrintWriter("output.txt");

        int count = 1;
        while (!(line == null)) {

            writer.print(count + ". " + line);
            count++;
            writer.println();
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
