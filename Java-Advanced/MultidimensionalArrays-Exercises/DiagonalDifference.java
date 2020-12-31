import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int sumOfPrimary = 0;
        int sumOfSecondary = 0;

        for (int row = 0; row < matrix.length; row++) {
            sumOfPrimary += matrix[row][row];
            sumOfSecondary += matrix[row][matrix.length - 1 - row];
        }
        System.out.println(Math.abs(sumOfPrimary - sumOfSecondary));
    }
}
