import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {

        Path inPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        BufferedReader bufferedReader = Files.newBufferedReader(inPath);
        String line = bufferedReader.readLine();

        while (line != null) {
            long sum = 0;
            for (int i = 0; i <line.length() ; i++) {
                sum+= line.charAt(i);
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }

    }
}
