import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("input.txt");
        Path output = Paths.get("06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        Files.write(output, lines);


    }
}
