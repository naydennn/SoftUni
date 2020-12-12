import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int n = 1;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(n + " ");
                n++;
                if (n > number) {
                    break;
                }
            }
            if (n > number) {
                break;
            }
            System.out.println();
        }
    }
}
