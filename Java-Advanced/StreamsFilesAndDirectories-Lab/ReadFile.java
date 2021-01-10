import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Nayden\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Nayden\\Desktop\\output.txt");
        int oneByte = inputStream.read();

            String table = ",.!?";

        while (scanner.hasNext()) {
            String line =  scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!table.contains(String.valueOf(symbol))) {
                    outputStream.write(symbol);
                }
            }

            outputStream.write(Integer.parseInt("\n"));
        }
    }
}
