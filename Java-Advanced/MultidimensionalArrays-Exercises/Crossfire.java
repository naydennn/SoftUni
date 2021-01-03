import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowsAndCols = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf(startNumber);
                startNumber++;
            }
        }
        String input = reader.readLine();

        while (!input.equals("Nuke it from orbit")) {

            int[] index = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = index[0];
            int col = index[1];
            int radius = index[2];

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInBound(i, col, matrix)) {
                    matrix[i][col] = null;
                }
            }
            for (int i = col - radius; i <= col + radius; i++) {
                if (isInBound(row, i, matrix)) {
                    matrix[row][i] = null;
                }
            }
            matrix = clearEmptyCells(matrix);
            input = reader.readLine();
        }
        printMatrix(matrix);
    }

    private static String[][] clearEmptyCells(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i]).filter(Objects::nonNull).toArray(String[]::new);
        }
        matrix = Arrays.stream(matrix).filter(l -> l.length > 0).toArray(String[][]::new);
        return matrix;
    }

    private static boolean isInBound(int currentRow, int currentCol, String[][] matrix) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}