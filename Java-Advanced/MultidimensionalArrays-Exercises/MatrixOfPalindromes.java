import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';
        for (int col = 0; col < cols; col++) {

            for (int row = 0; row < rows; row++) {
                String palindrome = "" + (char)(startLetter + row) + (char)(startLetter+col+row) + (char)(startLetter + row);

                matrix[row][col] = palindrome;
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] maxMatrix) {
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
