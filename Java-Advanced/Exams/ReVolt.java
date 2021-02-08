import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());

        int rowOfPlayer = 0;
        int colOfPlayer = 0;

        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int row = 0; row < rowsAndCols; row++) {
            String cols = scanner.nextLine();
            for (int col = 0; col < cols.length(); col++) {
                matrix[row][col] = cols.charAt(col);
                if (cols.charAt(col) == 'f') {
                    rowOfPlayer = row;
                    colOfPlayer = col;
                    matrix[row][col] = '-';
                }
            }
        }

        while (countOfCommands-- > 0) {
            String command = scanner.nextLine();

            switch (command) {
                case "left":
                    colOfPlayer--;
                    boolean isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                    colOfPlayer = isInMatrix ? colOfPlayer : rowsAndCols - 1;

                    char symbol = matrix[rowOfPlayer][colOfPlayer];

                    switch (symbol) {
                        case 'F':
                            System.out.println("Player won!");
                            printMatrix(matrix, rowsAndCols, rowOfPlayer, colOfPlayer);
                            return;
                        case 'T':
                            colOfPlayer++;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            colOfPlayer = isInMatrix ? colOfPlayer : 0;
                            break;
                        case 'B':
                            colOfPlayer--;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            colOfPlayer = isInMatrix ? colOfPlayer : rowsAndCols - 1;
                            countOfCommands++;
                    }
                    break;
                case "right":
                    colOfPlayer++;
                    isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                    colOfPlayer = isInMatrix ? colOfPlayer : 0;

                    symbol = matrix[rowOfPlayer][colOfPlayer];

                    switch (symbol) {
                        case 'F':
                            System.out.println("Player won!");
                            printMatrix(matrix, rowsAndCols, rowOfPlayer, colOfPlayer);
                            return;
                        case 'T':
                            colOfPlayer--;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            colOfPlayer = isInMatrix ? colOfPlayer : rowsAndCols - 1;
                            break;
                        case 'B':
                            colOfPlayer++;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            colOfPlayer = isInMatrix ? colOfPlayer : 0;
                            countOfCommands++;
                    }
                    break;
                case "down":
                    rowOfPlayer++;
                    isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                    rowOfPlayer = isInMatrix ? rowOfPlayer : 0;

                    symbol = matrix[rowOfPlayer][colOfPlayer];

                    switch (symbol) {
                        case 'F':
                            System.out.println("Player won!");
                            printMatrix(matrix, rowsAndCols, rowOfPlayer, colOfPlayer);
                            return;
                        case 'T':
                            rowOfPlayer--;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            colOfPlayer = isInMatrix ? colOfPlayer : rowsAndCols - 1;
                            break;
                        case 'B':
                            rowOfPlayer++;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            rowOfPlayer = isInMatrix ? rowOfPlayer : 0;
                            countOfCommands++;
                    }
                    break;
                case "up":
                    rowOfPlayer--;
                    isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                    rowOfPlayer = isInMatrix ? rowOfPlayer : rowsAndCols - 1;

                    symbol = matrix[rowOfPlayer][colOfPlayer];

                    switch (symbol) {
                        case 'F':
                            System.out.println("Player won!");
                            printMatrix(matrix, rowsAndCols, rowOfPlayer, colOfPlayer);
                            return;
                        case 'T':
                            rowOfPlayer++;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            rowOfPlayer = isInMatrix ? rowOfPlayer : 0;
                            break;
                        case 'B':
                            rowOfPlayer--;
                            isInMatrix = checkIsInMatrix(rowsAndCols, rowOfPlayer, colOfPlayer);
                            rowOfPlayer = isInMatrix ? rowOfPlayer : rowsAndCols - 1;
                            countOfCommands++;
                    }
                    break;
            }
        }
        System.out.println("Player lost!");
        printMatrix(matrix, rowsAndCols, rowOfPlayer, colOfPlayer);
    }

    private static boolean checkIsInMatrix(int rowsAndCols, int rowOfPlayer, int colOfPlayer) {
        return rowOfPlayer >= 0 && rowOfPlayer < rowsAndCols &&
                colOfPlayer >= 0 && colOfPlayer < rowsAndCols;
    }

    public static void printMatrix(char[][] matrix, int rowsAndCols, int rowOfPlayer, int colOfPlayer) {
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = 0; col < rowsAndCols; col++) {
                if (row == rowOfPlayer && col == colOfPlayer) {
                    matrix[row][col] = 'f';
                }
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
