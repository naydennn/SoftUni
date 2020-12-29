import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        boolean isEquals = compareMatrix(firstMatrix, secondMatrix);
        System.out.println(isEquals ? "equal" : "not equal");

    }

    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row <firstMatrix.length ; row++) {
           int[] firstCol = firstMatrix[row];
           int[] secondCol = secondMatrix[row];

           if (firstCol.length != secondCol.length) {
               return false;
           }

            for (int col = 0; col <firstCol.length ; col++) {
                if (firstCol[col] != secondCol[col]) {
                    return false;
                }
            }
        }
        return true;
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
