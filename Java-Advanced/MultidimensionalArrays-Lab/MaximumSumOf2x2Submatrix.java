import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int max = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row + 1][col]
                        + matrix[row + 1][col + 1] + matrix[row][col + 1];
                if (currentSum > max) {
                    max = currentSum;
                    maxMatrix[0][0] = matrix[row][col];
                    maxMatrix[0][1] = matrix[row][col + 1];
                    maxMatrix[1][1] = matrix[row + 1][col + 1];
                    maxMatrix[1][0] = matrix[row + 1][col];
                }
            }
        }
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
