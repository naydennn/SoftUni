import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        double minOdd = 1000000000.0;
        double maxOdd = -1000000000.0;
        double minEven = 1000000000.0;
        double maxEven = -1000000000.0;
        double oddSum = 0;
        double evenSum = 0;

        for (int i = 1; i <= number; i++) {
            double n = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += n;
                if (n > maxEven) {
                    maxEven = n;
                }
                if (n < minEven) {
                    minEven = n;
                }
            } else {
                oddSum += n;
                if (n > maxOdd) {
                    maxOdd = n;
                }
                if (n < minOdd) {
                    minOdd = n;
                }
            }
        }
        if (maxEven == -1000000000.0 && maxOdd == -1000000000.0) {
            System.out.printf("OddSum=%.2f,%nOddMin=No,%nOddMax=No,%nEvenSum=%.2f,%nEvenMin=No,%nEvenMax=No", oddSum, evenSum);
        } else if (maxEven == -1000000000.0) {
            System.out.printf("OddSum=%.2f,%nOddMin=%.2f,%nOddMax=%.2f,%nEvenSum=%.2f,%nEvenMin=No,%nEvenMax=No", oddSum, minOdd, maxOdd, evenSum);
        } else if (maxOdd == -1000000000.0) {
            System.out.printf("OddSum=%.2f,%nOddMin=No,%nOddMax=No,%nEvenSum=%.2f,%nEvenMin=%.2f,%nEvenMax=%.2f", oddSum, evenSum, minEven, maxEven);
        } else {
            System.out.printf("OddSum=%.2f,%nOddMin=%.2f,%nOddMax=%.2f,%nEvenSum=%.2f,%nEvenMin=%.2f,%nEvenMax=%.2f", oddSum, minOdd, maxOdd, evenSum, minEven, maxEven);

        }
    }
}

