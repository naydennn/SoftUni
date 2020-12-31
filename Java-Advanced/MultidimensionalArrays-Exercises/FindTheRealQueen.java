import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                if (symbol == 'q') {
                    if (checkForRealQueen(matrix, row, col, symbol)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }

    }

    private static boolean checkForRealQueen(char[][] matrix, int row, int col, char symbol) {
        int index = col;
        for (int c = 0; c < matrix[row].length; c++) {
            if (c != index) {
                char symbolToCheck = matrix[row][c];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        index = row;
        for (int r = 0; r < matrix.length; r++) {
            if (r != index) {
                char symbolToCheck = matrix[r][col];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        for (int r = 0; r < row; r++) {
            if (checkIsBound(matrix, row - 1 - r, col - 1 - r)) {
                char symbolToCheck = matrix[row - 1 - r][col - 1 - r];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        index = 8 - row;
        for (int r = 0; r < index; r++) {
            if (checkIsBound(matrix, row + 1 + r, col + 1 + r)) {
                char symbolToCheck = matrix[row + 1 + r][col + 1 + r];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        for (int r = 0; r < 8; r++) {
            if (checkIsBound(matrix, row - 1 - r, col + 1 + r)) {
                char symbolToCheck = matrix[row - 1 - r][col + 1 + r];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        for (int r = 0; r < 8; r++) {
            if (checkIsBound(matrix, row + 1 + r, col - 1 - r)) {
                char symbolToCheck = matrix[row + 1 + r][col - 1 - r];
                if (symbolToCheck == symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkIsBound(char[][] matrix, int row, int col) {
        return row  >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[row].length;
    }
}
