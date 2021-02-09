import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowsAndCows][rowsAndCows];

        int rowOfSnake = 0;
        int colOfSnake = 0;
        for (int row = 0; row < matrix.length; row++) {
            String rows = scanner.nextLine();
            for (int col = 0; col <rows.length() ; col++) {
                matrix[row][col] = rows.charAt(col);
                if (rows.charAt(col) == 'S') {
                    rowOfSnake = row;
                    colOfSnake = col;
                }
            }
        }
        int food = 0;
        boolean isInMatrix = true;

        while (food < 10 && isInMatrix) {
            String position = scanner.nextLine();

            switch (position) {
                case "left":
                    isInMatrix = checkSnake(rowOfSnake, colOfSnake - 1, rowsAndCows);
                    if (isInMatrix) {
                        matrix[rowOfSnake][colOfSnake] = '.';
                        colOfSnake = colOfSnake -1;
                        switch (matrix[rowOfSnake][colOfSnake]) {
                            case 'B':
                                int[] positionOfB = checkForAnotherB(matrix, rowOfSnake, colOfSnake);
                                matrix[rowOfSnake][colOfSnake] = '.';
                                rowOfSnake = positionOfB[0];
                                colOfSnake = positionOfB[1];
                                break;
                            case '*':
                                food+=1;
                                break;
                        }
                        matrix[rowOfSnake][colOfSnake] = '.';
                    }
                    break;
                case "right":
                    isInMatrix = checkSnake(rowOfSnake, colOfSnake + 1, rowsAndCows);
                    if (isInMatrix) {
                        matrix[rowOfSnake][colOfSnake] = '.';
                        colOfSnake = colOfSnake +1;
                        switch (matrix[rowOfSnake][colOfSnake]) {
                            case 'B':
                                int[] positionOfB = checkForAnotherB(matrix, rowOfSnake, colOfSnake);
                                matrix[rowOfSnake][colOfSnake] = '.';
                                rowOfSnake = positionOfB[0];
                                colOfSnake = positionOfB[1];
                                break;
                            case '*':
                                food+=1;
                                break;
                        }
                        matrix[rowOfSnake][colOfSnake] = '.';
                    }
                    break;
                case "up":
                    isInMatrix = checkSnake(rowOfSnake - 1, colOfSnake, rowsAndCows);
                    if (isInMatrix) {
                        matrix[rowOfSnake][colOfSnake] = '.';
                        rowOfSnake = rowOfSnake - 1;
                        switch (matrix[rowOfSnake][colOfSnake]) {
                            case 'B':
                                int[] positionOfB = checkForAnotherB(matrix, rowOfSnake, colOfSnake);
                                matrix[rowOfSnake][colOfSnake] = '.';
                                rowOfSnake = positionOfB[0];
                                colOfSnake = positionOfB[1];
                                break;
                            case '*':
                                food+=1;
                                break;
                        }
                        matrix[rowOfSnake][colOfSnake] = '.';
                    }
                    break;
                case "down":
                    isInMatrix = checkSnake(rowOfSnake + 1, colOfSnake, rowsAndCows);
                    if (isInMatrix) {
                        matrix[rowOfSnake][colOfSnake] = '.';
                        rowOfSnake = rowOfSnake + 1;
                        switch (matrix[rowOfSnake][colOfSnake]) {
                            case 'B':
                                int[] positionOfB = checkForAnotherB(matrix, rowOfSnake, colOfSnake);
                                matrix[rowOfSnake][colOfSnake] = '.';
                                rowOfSnake = positionOfB[0];
                                colOfSnake = positionOfB[1];
                                break;
                            case '*':
                                food+=1;
                                break;
                        }
                        matrix[rowOfSnake][colOfSnake] = '.';
                    }
                    break;
            }
        }

        if (food ==10) {
            matrix[rowOfSnake][colOfSnake] = 'S';
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + food);
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

    private static int[] checkForAnotherB(char[][] matrix, int rowOfSnake, int colOfSnake) {
        int[] positionOfB = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row != rowOfSnake && col != colOfSnake) {
                    if (matrix[row][col] == 'B'){
                        positionOfB[0] = row;
                        positionOfB[1] = col;
                    }
                }
            }
        }
        return positionOfB;
    }

    private static boolean checkSnake(int rowOfSnake, int colOfSnake, int rowsAndCows) {
        return rowOfSnake >= 0 && rowOfSnake < rowsAndCows
                && colOfSnake >= 0 && colOfSnake <rowsAndCows;
    }
}
