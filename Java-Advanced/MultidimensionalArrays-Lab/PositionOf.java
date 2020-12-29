import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = createMatrix(scanner);
        scanner.nextLine();
        int numberToCompare = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row <firstMatrix.length ; row++) {
            int[] matrixCol = firstMatrix[row];
            for (int col = 0; col <matrixCol.length ; col++) {
                int numToCompare = firstMatrix[row][col];
                if (numToCompare == numberToCompare) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }

    }
    private static int[][] createMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        scanner.nextLine();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int num = scanner.nextInt();
                matrix[row][col] = num;
            }
        }
        return matrix;
    }
}
