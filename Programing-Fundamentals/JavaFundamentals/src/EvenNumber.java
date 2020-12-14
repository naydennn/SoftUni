import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MAX_VALUE;

        for (int i = 1; i <= max  ; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number % 2 !=0) {
                System.out.println("Please write an even number.");
            } else {
                number = Math.abs(number);
                System.out.printf("The number is: %d", number);
                break;
            }
        }
    }
}
