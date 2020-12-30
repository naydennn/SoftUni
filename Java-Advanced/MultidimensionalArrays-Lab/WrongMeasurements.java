import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readMatrix(scanner, "\\s+");
        }
        int[] wrongIndexes = readMatrix(scanner, "\\s+");
        int row = wrongIndexes[0];
        int col = wrongIndexes[1];

        int wrongNum = matrix[row][col];
        List<Integer> numbers = new ArrayList<>();
        List<int[]> indexes = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[row].length; c++) {
                if (matrix[r][c] == wrongNum) {
                    indexes.add(new int[] {r , c});
                    numbers.add(getSumOfNumbers(matrix, r, c));
                }
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCol = indexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = numbers.get(i);
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static int getSumOfNumbers(int[][] matrix, int r, int c) {
        int sum = 0;
        if (isNotOfBound(matrix, r +1, c) && matrix[r + 1][c] != matrix[r][c]) {
            sum += matrix[r + 1][c];
        }
        if (isNotOfBound(matrix, r - 1, c) && matrix[r - 1][c] != matrix[r][c]) {
            sum += matrix[r - 1][c];
        }
        if (isNotOfBound(matrix, r, c + 1) && matrix[r][c + 1] != matrix[r][c]) {
            sum += matrix[r][c + 1];
        }
        if (isNotOfBound(matrix, r, c - 1) && matrix[r][c - 1] != matrix[r][c]) {
            sum += matrix[r][c - 1];
        }

        return sum;
    }

    private static boolean isNotOfBound(int[][] matrix, int r, int c) {
        return r >=0 && r < matrix.length && c >=0 && c<matrix[r].length;
    }


    public static int[] readMatrix(Scanner scanner, String separator) {
        return Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }
}
