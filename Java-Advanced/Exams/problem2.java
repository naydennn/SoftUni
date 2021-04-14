import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());

        int rowOfClient = 0;
        int colOfClient = 0;

        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int row = 0; row < rowsAndCols; row++) {
            String cols = scanner.nextLine();
            for (int col = 0; col < cols.length(); col++) {
                matrix[row][col] = cols.charAt(col);
                if (cols.charAt(col) == 'S') {
                    rowOfClient = row;
                    colOfClient = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int money = 0;
        boolean inMatrix = true;

        while (money < 50 && inMatrix) {

            String position = scanner.nextLine();


            switch (position) {
                case "left":
                    colOfClient -= 1;
                    inMatrix = checkInMatrix(rowOfClient, colOfClient, rowsAndCols);
                    if (inMatrix) {
                        if (matrix[rowOfClient][colOfClient] == 'P') {

                            int[] values = checkForAnotherP(rowOfClient, colOfClient, matrix);
                            matrix[rowOfClient][colOfClient] = '-';
                            rowOfClient = values[0];
                            colOfClient = values[1];
                            matrix[rowOfClient][colOfClient] = '-';

                        } else if (Character.isDigit(matrix[rowOfClient][colOfClient])) {
                            money += Character.getNumericValue(matrix[rowOfClient][colOfClient]);
                            matrix[rowOfClient][colOfClient] = '-';
                        }
                    }
                    break;
                case "right":
                    colOfClient += 1;
                    inMatrix = checkInMatrix(rowOfClient, colOfClient, rowsAndCols);
                    if (inMatrix) {

                        if (matrix[rowOfClient][colOfClient] == 'P') {

                            int[] values = checkForAnotherP(rowOfClient, colOfClient, matrix);
                            matrix[rowOfClient][colOfClient] = '-';
                            rowOfClient = values[0];
                            colOfClient = values[1];
                            matrix[rowOfClient][colOfClient] = '-';

                        } else if (Character.isDigit(matrix[rowOfClient][colOfClient])) {
                            money += Character.getNumericValue(matrix[rowOfClient][colOfClient]);
                            matrix[rowOfClient][colOfClient] = '-';
                        }
                    }
                    break;
                case "up":
                    rowOfClient -= 1;
                    inMatrix = checkInMatrix(rowOfClient, colOfClient, rowsAndCols);
                    if (inMatrix) {
                        if (matrix[rowOfClient][colOfClient] == 'P') {

                            int[] values = checkForAnotherP(rowOfClient, colOfClient, matrix);
                            matrix[rowOfClient][colOfClient] = '-';
                            rowOfClient = values[0];
                            colOfClient = values[1];
                            matrix[rowOfClient][colOfClient] = '-';

                        } else if (Character.isDigit(matrix[rowOfClient][colOfClient])) {
                            money += Character.getNumericValue(matrix[rowOfClient][colOfClient]);
                            matrix[rowOfClient][colOfClient] = '-';
                        }
                    }
                    break;
                case "down":
                    rowOfClient += 1;
                    inMatrix = checkInMatrix(rowOfClient, colOfClient, rowsAndCols);
                    if (inMatrix) {

                        if (matrix[rowOfClient][colOfClient] == 'P') {

                            int[] values = checkForAnotherP(rowOfClient, colOfClient, matrix);
                            matrix[rowOfClient][colOfClient] = '-';
                            rowOfClient = values[0];
                            colOfClient = values[1];
                            matrix[rowOfClient][colOfClient] = '-';

                        } else if (Character.isDigit(matrix[rowOfClient][colOfClient])) {
                            money += Character.getNumericValue(matrix[rowOfClient][colOfClient]);
                            matrix[rowOfClient][colOfClient] = '-';
                        }
                    }
                    break;

            }
        }
        if (!inMatrix) {
            System.out.println("Bad news! You are out of the pastry shop.");

        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            matrix[rowOfClient][colOfClient] = 'S';
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

    private static int[] checkForAnotherP(int rowOfClient, int colOfClient, char[][] matrix) {
        int[] positionOfP = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row != rowOfClient && col != colOfClient) {
                    if (matrix[row][col] == 'P') {
                        positionOfP[0] = row;
                        positionOfP[1] = col;
                    }
                }
            }
        }
        return positionOfP;
    }

    private static boolean checkInMatrix(int rowOfClient, int colOfClient, int rowsAndCows) {
        return rowOfClient >= 0 && rowOfClient < rowsAndCows
                && colOfClient >= 0 && colOfClient < rowsAndCows;
    }
}
