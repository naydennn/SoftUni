import java.util.Scanner;

public class l05EvenAndOddSumSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] numberAsString = line.split(" ");

        int[] numbers = new int[numberAsString.length];
        int evenSum = 0, oddSum = 0;

        for (int i = 0; i < numbers.length; i++) {
             numbers[i] = Integer.parseInt(numberAsString[i]);
             if (numbers[i] % 2 == 0) {
                 evenSum += numbers[i];
             } else {
                 oddSum += numbers[i];
             }
        }
        System.out.println(evenSum - oddSum);
    }
}
