import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);
            boolean isPrime = true;
            if (num == 1) {
                isPrime = false;
            }

            if (num < 0) {
                System.out.println("Number is negative.");
            } else {
                for (int i = 2; i <= (num / 2); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primeSum += num;
                } else {
                    nonPrimeSum += num;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: " + primeSum);
        System.out.println("Sum of all non prime numbers is: " + nonPrimeSum);
    }
}