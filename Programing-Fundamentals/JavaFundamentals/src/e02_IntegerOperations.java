import java.util.Scanner;

public class e02_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNUmber = scanner.nextInt();
        int fourthNumber = scanner.nextInt();

        int result = ((firstNumber + secondNumber) / thirdNUmber) * fourthNumber;
        System.out.println(result);
    }
}
