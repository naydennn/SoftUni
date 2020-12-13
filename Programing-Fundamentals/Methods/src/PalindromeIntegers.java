import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            boolean isPalindrome = getBoolean(input);
            System.out.println(isPalindrome);
            input = scanner.nextLine();
        }
    }
    public static boolean getBoolean(String input) {
        boolean isPalindrome = false;
        if (input.charAt(0) == input.charAt(input.length()-1)) {
            isPalindrome = true;
            return isPalindrome;
        }
        return isPalindrome;
    }
}
