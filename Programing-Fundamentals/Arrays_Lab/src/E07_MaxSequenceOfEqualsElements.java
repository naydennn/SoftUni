import java.util.Arrays;
import java.util.Scanner;

public class E07_MaxSequenceOfEqualsElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int count = 0;
        int index = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
                if (count > max) {
                    index = array[i];
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        for (int i = 0; i <= max ; i++) {
            System.out.print(index+ " ");
        }
    }
}
