import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int max = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = getSum(matrix, row, col);
                if (sum > max) {
                    max = sum;
                    getMaxMatrix(matrix, maxMatrix, row, col);
                }
            }
        }
        System.out.println("Sum = " + max);
        printMatrix(maxMatrix);
    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void getMaxMatrix(int[][] matrix, int[][] maxMatrix, int row, int col) {
        maxMatrix[0][0] = matrix[row][col];
        maxMatrix[1][0] = matrix[row + 1][col];
        maxMatrix[2][0] = matrix[row + 2][col];
        maxMatrix[0][1] = matrix[row][col + 1];
        maxMatrix[0][2] = matrix[row][col + 2];
        maxMatrix[1][1] = matrix[row + 1][col + 1];
        maxMatrix[2][2] = matrix[row + 2][col + 2];
        maxMatrix[1][2] = matrix[row + 1][col + 2];
        maxMatrix[2][1] = matrix[row + 2][col + 1];
    }

    private static int getSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row + 1][col]
                + matrix[row + 2][col] + matrix[row][col + 1]
                + matrix[row][col + 2] + matrix[row + 1][col + 1]
                + matrix[row + 2][col + 2] + matrix[row + 1][col + 2] +
                matrix[row + 2][col + 1];
    }
}
