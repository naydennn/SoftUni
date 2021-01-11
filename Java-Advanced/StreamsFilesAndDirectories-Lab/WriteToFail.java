import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFail {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\Java\\StreamsFilesAndDirectories\\input.txt";
        String outPath =  "D:\\Java\\StreamsFilesAndDirectories\\02.WriteToFileOutput.txt";

        String table = ",.!?";

        FileInputStream inputStream = new FileInputStream(inPath);
        FileOutputStream outputStream = new FileOutputStream(outPath);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (!table.contains(String.valueOf(symbol))){
                    outputStream.write(symbol);
                }
            }

            outputStream.write('\n');
        }
    }
}
