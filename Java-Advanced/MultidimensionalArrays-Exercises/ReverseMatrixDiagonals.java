import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                boolean flag = false;
                printDiagonals(matrix, row, col, rows, cols);
            }
        }
    }

    private static void printDiagonals(String[][] matrix, int row, int col, int rows, int cols) {
        int count = rows + cols;
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (isInBound(row, col, rows, cols)) {
                if (matrix[row][col] != null) {
                    System.out.print(matrix[row][col] + " ");
                    matrix[row][col] = null;
                    col++;
                    row--;
                    flag = true;
                }
            } else {
                break;
            }
        }
        if (flag) {
            System.out.println();
        }
    }

    private static boolean isInBound(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
