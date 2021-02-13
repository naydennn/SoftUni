import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowsAndCols][rowsAndCols];

        int rowOfMe = 0;
        int colOfMe = 0;

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line.charAt(col);
                if (line.charAt(col) == 'S') {
                    rowOfMe = row;
                    colOfMe = col;
                }
            }
        }
        int money = 0;
        boolean isInMatrix = checkIsOutOfMatrix(rowsAndCols, rowOfMe, colOfMe);
        matrix[rowOfMe][colOfMe] = '-';

        while (money < 50 && isInMatrix) {
            String move = scanner.nextLine();
            switch (move) {
                case "left":
                    isInMatrix = checkIsOutOfMatrix(rowsAndCols, rowOfMe, colOfMe - 1);
                    if (isInMatrix) {
                        colOfMe = colOfMe - 1;
                        if (Character.isDigit(matrix[rowOfMe][colOfMe])) {
                            money += Character.getNumericValue(matrix[rowOfMe][colOfMe]);
                        } else if (matrix[rowOfMe][colOfMe] == 'O') {
                            matrix[rowOfMe][colOfMe] = '-';
                            int[] rowAndCol = findAnotherPillar(matrix, rowOfMe, colOfMe);
                            rowOfMe = rowAndCol[0];
                            colOfMe = rowAndCol[1];
                        }
                    }
                    matrix[rowOfMe][colOfMe] = '-';
                    break;
                case "right":
                    isInMatrix = checkIsOutOfMatrix(rowsAndCols, rowOfMe, colOfMe + 1);
                    if (isInMatrix) {
                        colOfMe = colOfMe + 1;
                        if (Character.isDigit(matrix[rowOfMe][colOfMe])) {
                            money += Character.getNumericValue(matrix[rowOfMe][colOfMe]);
                        } else if (matrix[rowOfMe][colOfMe] == 'O') {
                            matrix[rowOfMe][colOfMe] = '-';
                            int[] rowAndCol = findAnotherPillar(matrix, rowOfMe, colOfMe);
                            rowOfMe = rowAndCol[0];
                            colOfMe = rowAndCol[1];
                        }
                    }
                    matrix[rowOfMe][colOfMe] = '-';
                    break;
                case "up":
                    isInMatrix = checkIsOutOfMatrix(rowsAndCols, rowOfMe -1, colOfMe);
                    if (isInMatrix) {
                        rowOfMe = rowOfMe - 1;
                        if (Character.isDigit(matrix[rowOfMe][colOfMe])) {
                            money += Character.getNumericValue(matrix[rowOfMe][colOfMe]);
                        } else if (matrix[rowOfMe][colOfMe] == 'O') {
                            matrix[rowOfMe][colOfMe] = '-';
                            int[] rowAndCol = findAnotherPillar(matrix, rowOfMe, colOfMe);
                            rowOfMe = rowAndCol[0];
                            colOfMe = rowAndCol[1];
                        }
                    }
                    matrix[rowOfMe][colOfMe] = '-';
                    break;
                case "down":
                    isInMatrix = checkIsOutOfMatrix(rowsAndCols, rowOfMe + 1, colOfMe);
                    if (isInMatrix) {
                        rowOfMe = rowOfMe + 1;
                        if (Character.isDigit(matrix[rowOfMe][colOfMe])) {
                            money += Character.getNumericValue(matrix[rowOfMe][colOfMe]);
                        } else if (matrix[rowOfMe][colOfMe] == 'O') {
                            matrix[rowOfMe][colOfMe] = '-';
                            int[] rowAndCol = findAnotherPillar(matrix, rowOfMe, colOfMe);
                            rowOfMe = rowAndCol[0];
                            colOfMe = rowAndCol[1];
                        }
                    }
                    matrix[rowOfMe][colOfMe] = '-';
                    break;
            }
        }
        if (money < 50) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            matrix[rowOfMe][colOfMe] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] findAnotherPillar(char[][] matrix, int rowOfMe, int colOfMe) {
        int[] result = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row != rowOfMe && col != colOfMe && matrix[row][col] == 'O') {
                    result[0] = row;
                    result[1] = col;
                }
            }
        }
        return result;
    }

    private static boolean checkIsOutOfMatrix(int rowsAndCols, int row, int col) {
        return row >= 0 && row < rowsAndCols &&
                col >= 0 && col < rowsAndCols;
    }
}
