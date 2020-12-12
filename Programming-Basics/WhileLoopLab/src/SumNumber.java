import java.util.Scanner;

public class SumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (sum < number) {
            int input = Integer.parseInt(scanner.nextLine());
            sum += input;
        }
        System.out.println(sum);

    }
}
