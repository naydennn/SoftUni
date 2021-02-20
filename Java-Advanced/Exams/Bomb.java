import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndCows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowsAndCows][rowsAndCows];
        String[] moves = scanner.nextLine().split(",");

        int rowStart = 0;
        int colStart = 0;
        int bombs = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col].equals("s")) {
                    rowStart = row;
                    colStart = col;
                } else if (matrix[row][col].equals("B")) {
                    bombs++;
                }
            }
        }


        int countOfFoundBomb = 0;
        boolean isInMatrix;
        boolean foundEnd = false;

        for (String move : moves) {
            if (foundEnd && countOfFoundBomb >= bombs) {
                break;
            }
            switch (move) {
                case "left":
                    isInMatrix = checkIsInMatrix(rowsAndCows, rowStart, colStart - 1);
                    colStart = isInMatrix ? colStart - 1 : colStart;
                    switch (matrix[rowStart][colStart]) {
                        case "B":
                            System.out.println("You found a bomb!");
                            countOfFoundBomb++;
                            matrix[rowStart][colStart] = "+";
                            break;
                        case "e":
                            foundEnd = true;
                            break;
                    }
                    break;
                case "right":
                    isInMatrix = checkIsInMatrix(rowsAndCows, rowStart, colStart + 1);
                    colStart = isInMatrix ? colStart + 1 : colStart;
                    switch (matrix[rowStart][colStart]) {
                        case "B":
                            System.out.println("You found a bomb!");
                            countOfFoundBomb++;
                            matrix[rowStart][colStart] = "+";
                            break;
                        case "e":
                            foundEnd = true;
                            break;
                    }
                    break;
                case "up":
                    isInMatrix = checkIsInMatrix(rowsAndCows, rowStart - 1, colStart);
                    rowStart = isInMatrix ? rowStart - 1 : rowStart;
                    switch (matrix[rowStart][colStart]) {
                        case "B":
                            System.out.println("You found a bomb!");
                            countOfFoundBomb++;
                            matrix[rowStart][colStart] = "+";
                            break;
                        case "e":
                            foundEnd = true;
                            break;
                    }
                    break;
                case "down":
                    isInMatrix = checkIsInMatrix(rowsAndCows, rowStart + 1, colStart);
                    rowStart = isInMatrix ? rowStart + 1 : rowStart;
                    switch (matrix[rowStart][colStart]) {
                        case "B":
                            System.out.println("You found a bomb!");
                            countOfFoundBomb++;
                            matrix[rowStart][colStart] = "+";
                            break;
                        case "e":
                            foundEnd = true;
                            break;
                    }
                    break;
            }

        }
        if (countOfFoundBomb >= bombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (foundEnd) {
            bombs = bombs - countOfFoundBomb;
            System.out.println("END! " + bombs + " bombs left on the field");
        } else {
            bombs = bombs - countOfFoundBomb;
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombs, rowStart, colStart);
        }
    }

    private static boolean checkIsInMatrix(int rowsAndCows, int rowStart, int colStart) {
        return rowStart >= 0 && rowStart < rowsAndCows &&
                colStart >= 0 && colStart < rowsAndCows;
    }

}
