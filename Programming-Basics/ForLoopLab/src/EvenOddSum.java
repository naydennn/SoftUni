import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 1; i <=n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                sumEven += number;
            } else {
                sumOdd +=number;
            }
        }
        if (sumEven == sumOdd) {
            System.out.printf("Yes%nSum = %d", sumEven);
        } else  {
            System.out.printf("No %nDiff = %d", Math.abs(sumOdd - sumEven));
        }
    }
}
