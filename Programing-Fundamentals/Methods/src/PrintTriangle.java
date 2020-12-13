import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            printIncreasing(i) ;
        }
        for (int i = number-1; i >= 1 ; i--) {
            printDecreasing(i);
        }
    }

    public static void printIncreasing(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printDecreasing(int number) {
        for (int i = 1; i <= number ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


