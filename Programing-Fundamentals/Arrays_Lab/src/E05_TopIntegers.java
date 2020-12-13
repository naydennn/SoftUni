import java.util.Arrays;
import java.util.Scanner;

public class E05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] line = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int i = 0; i < line.length ; i++) {
            boolean isTop = true;
            int number = line[i];
            for (int j = i +1; j < line.length ; j++) {
                if (number <= line[j]) {
                    isTop = false;
                }
            }
            if (isTop) {
                System.out.print(number + " ");
            }
        }
    }
}
