import java.util.Arrays;
import java.util.Scanner;

public class E08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrays = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < arrays.length; i++) {
            int magicSum = 0;

            for (int j = i + 1; j < arrays.length; j++) {
                magicSum = arrays[i] + arrays[j];

                if (magicSum == sum) {
                    System.out.println(arrays[i] + " " + arrays[j]);
                }
            }
        }
    }
}

