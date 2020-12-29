import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = createMatrix(rows, cols, scanner);
        char[][] secondMatrix = createMatrix(rows, cols, scanner);
        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            char[] currentCol = firstMatrix[row];
            for (int col = 0; col < currentCol.length ; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < resultMatrix.length; row++) {
            char[] currentArr = resultMatrix[row];
            for (int col = 0; col < currentArr.length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] createMatrix(int rows, int cols, Scanner scanner) {

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                char symbol = symbols[col].charAt(0);
                matrix[row][col] = symbol;
            }
        }
        return matrix;
    }
}
