import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        double sum = 0;
        double sumWithOutMaxNumber = 0;

        for (int i = 1; i <= n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > max) {
                max = number;
            }
            sumWithOutMaxNumber = sum - max;
        }
        if (max == sumWithOutMaxNumber) {
            System.out.printf("Yes%nSum = %d", max);
        } else {
            System.out.printf("No%nDiff = %.0f", Math.abs(max - sumWithOutMaxNumber));
        }
    }
}
