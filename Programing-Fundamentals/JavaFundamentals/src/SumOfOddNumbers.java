import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MAX_VALUE;
        int count = 0;
        int sum = 0;

        for (int i =0 ; i < max ; i++) {

            if (i % 2 != 0) {
                System.out.println(i);
                sum+=i;
                count++;
            }
            if (count >= n) {
                break;
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}
