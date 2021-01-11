import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\Java\\StreamsFilesAndDirectories\\input.txt";
        String outPath = "D:\\Java\\StreamsFilesAndDirectories\\04.ExtractIntegers.txt";

        PrintWriter outputStream = new PrintWriter(outPath);

        Scanner scanner = new Scanner(new FileInputStream(inPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                outputStream.println(scanner.nextInt());
            }
            scanner.next();
        }
        outputStream.close();
    }
}
