import java.util.Scanner;

public class e01_TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num ; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
