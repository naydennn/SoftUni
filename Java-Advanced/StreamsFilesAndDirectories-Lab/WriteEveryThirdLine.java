import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\Java\\StreamsFilesAndDirectories\\input.txt";
        String outPath = "D:\\Java\\StreamsFilesAndDirectories\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath));
        PrintWriter printWriter = new PrintWriter(new FileWriter(outPath));

        Stream<String> lines = bufferedReader.lines();
        List<String> strings = lines.collect(Collectors.toList());

        for (int i = 0; i < strings.size(); i++) {
            if ((i +1)  % 3 == 0) {
                printWriter.println(strings.get(i));
            }
        }
        printWriter.close();
    }
}
