import java.util.Scanner;

public class SumMatrixElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(numbers[0]);
        int cols = Integer.parseInt(numbers[1]);

        int[][] matrix = createMatrix(rows,cols,scanner);
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] currCol = matrix[row];
            for (int col = 0; col < currCol.length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);


    }
    private static int[][] createMatrix(int rows, int cols, Scanner scanner) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                int num = Integer.parseInt(symbols[col]);
                matrix[row][col] = num;
            }
        }
        return matrix;
    }
}
