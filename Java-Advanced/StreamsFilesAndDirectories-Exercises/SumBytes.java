import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        Path inPath = Paths.get("C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        BufferedReader bufferedReader = Files.newBufferedReader(inPath);
        String line = bufferedReader.readLine();

        long sum = 0;
        while (line != null) {

            for (int i = 0; i <line.length() ; i++) {
                sum+= line.charAt(i);
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        System.out.println(sum);

    }
}
