import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        int degree = getDegrees(scanner);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }

        int rows = words.size();
        int cols = getCol(words);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                if (col< words.get(row).length()) {
                    matrix[row][col] = words.get(row).charAt(col);
                }else {
                    matrix[row][col] = ' ';
                }
            }
        }


        switch (degree) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                oneRotation(rows, cols, matrix);
                break;
            case 180:
                twoRotation(rows, cols, matrix);
                break;
            case 270:
                for (int col = cols-1; col >=0 ; col--) {
                    for (int row = 0; row <rows ; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }


    }

    private static void twoRotation(int rows, int cols, char[][] matrix) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >=0 ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void oneRotation(int rows, int cols, char[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows -1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int getCol(List<String> words) {
        int max = Integer.MIN_VALUE;
        for (String s:words) {
            int size = s.length();
            if (size > max) {
                max = size;
            }
        }
        return max;
    }

    private static int getDegrees(Scanner scanner) {
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("[A-Z][a-z]+\\((?<degree>\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        int degree = 0;
        if (matcher.find()) {
            degree = Integer.parseInt(matcher.group("degree"));
        }
        if (degree >= 360){
            return degree % 360;
        }
        return degree;
    }

    private static void printMatrix(char[][] maxMatrix) {
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
