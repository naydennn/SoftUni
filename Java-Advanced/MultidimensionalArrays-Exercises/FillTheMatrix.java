import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[size][size];
        int number = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        } else if (pattern.equals("B")) {
            int col = 0;
           while (col < matrix.length) {
               if (col % 2 == 0) {
                   for (int i = 0; i < 1; i++) {
                       for (int row = 0; row < size; row++) {
                           matrix[row][col] = number;
                           number++;
                       }
                   }
               }else {
                   for (int i = 0; i < 1; i++) {
                       for (int row = size-1; row >= 0; row--) {
                           matrix[row][col] = number;
                           number++;
                       }
                   }
               }
               col++;
           }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

