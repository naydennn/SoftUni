import java.util.Scanner;

public class Sequence2k {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int k = 1;
        while (k <= number) {
            System.out.println(k);
            k = k * 2 + 1;
        }
    }
}
