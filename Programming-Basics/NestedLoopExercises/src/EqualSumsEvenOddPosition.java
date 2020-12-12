import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secoundNumber = Integer.parseInt(scanner.nextLine());



        for (int i = firstNumber; i <= secoundNumber ; i++) {
            int evenSum = 0;
            int oddSum = 0;
            String number = "" + i;
            for (int j = 0; j < number.length() ; j++) {
                int currentNum = Integer.parseInt("" + number.charAt(j));
                if (j % 2 ==0) {
                    evenSum += currentNum;
                } else {
                    oddSum += currentNum;
                }
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
