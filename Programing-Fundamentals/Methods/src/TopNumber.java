import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean checkDigit = false;
        boolean checkOddDigit = false;

        for (int i = 1; i <= n; i++) {
            checkDigit = checkDivisibleNumber(i);
            checkOddDigit = checkOneOddDigit(i);

            if (checkDigit && checkOddDigit ){
                System.out.println(i);
            }
        }
    }

    public static boolean checkDivisibleNumber(int num) {
        boolean check = false;
        int sumDigit = 0;
        while (num > 0){
            sumDigit += num % 10;
            num /= 10;
        }
        if (sumDigit % 8 == 0) {
            return check = true;
        }
        return check;
    }
    public static boolean checkOneOddDigit (int num){
        boolean oddDigit = false;
       String check = String.valueOf(num);
        for (int i = 0; i <check.length() ; i++) {
            if (check.charAt(i) == '1' || check.charAt(i) == '3' || check.charAt(i) == '5' || check.charAt(i) == '7'||check.charAt(i) == '9') {
             return oddDigit = true;
            }
        }
        return oddDigit;
    }
}
