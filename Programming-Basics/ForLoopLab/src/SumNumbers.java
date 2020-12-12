import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= numbers ; i++) {
            int n1 = Integer.parseInt(scanner.nextLine());
            sum += n1 ;

        }
        System.out.println(sum);

    }
}
