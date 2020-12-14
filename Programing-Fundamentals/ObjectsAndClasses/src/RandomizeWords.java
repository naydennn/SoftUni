import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");

        Random rnd = new Random();

        for (int i = 0; i < line.length ; i++) {
            int pos1 = rnd.nextInt(line.length);
            int pos2 = rnd.nextInt(line.length);
            String old = line[pos1];
            line[pos1] = line[pos2];
            line[pos2] =old;
        }
        System.out.println(String.join(System.lineSeparator(), line));
    }
}
