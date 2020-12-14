import java.util.Scanner;

public class e02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int sum = 0;

        for (char i = 0; i < number.length() ; i++) {
            sum += number.charAt(i) - 48;
        }
        System.out.println(sum);
    }
}
