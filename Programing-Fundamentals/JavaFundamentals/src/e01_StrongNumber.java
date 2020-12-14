import java.util.Scanner;

public class e01_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String number = firstNumber + "";
        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            int fact = 1;
            int num = number.charAt(i) - 48;
            for (int j = num; j >= 1; j--) {
                fact *= j;
            }
            result += fact;
        }

        if (result == firstNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
       }
    }
}
