import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        int characters = checkPasswordForCharacters(password);
        boolean lettersAndDigits = checkForLetterAndDigit(password);
        int digit = checkForDigit(password);

        boolean isValidCharacter = false;
        boolean isValidLettersAndDigit = false;
        boolean isValidDigit = false;

        if (characters >=6 && characters <= 10) {
            isValidCharacter = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (lettersAndDigits){
            isValidLettersAndDigit = true;
        } else {
            System.out.println("Password must consist only of letters and digits");
        }
        if (digit >= 2) {
            isValidDigit = true;
        } else {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidCharacter && isValidDigit && isValidLettersAndDigit) {
            System.out.println("Password is valid");
        }
    }

    public static int checkForDigit(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 48 || password.charAt(i) == 49 || password.charAt(i) == 50 || password.charAt(i) == 51 || password.charAt(i) == 52 || password.charAt(i) == 53 || password.charAt(i) == 54 || password.charAt(i) == 55 || password.charAt(i) == 56 || password.charAt(i) == 57) {
                count++;
            }
        }
        return count;
    }

    public static int checkPasswordForCharacters(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            count++;
        }
        return count;
    }

    public static boolean checkForLetterAndDigit(String password) {
        boolean check = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 48 || password.charAt(i) == 49 || password.charAt(i) == 50 || password.charAt(i) == 51 || password.charAt(i) == 52 || password.charAt(i) == 53 || password.charAt(i) == 54 || password.charAt(i) == 55 || password.charAt(i) == 56 || password.charAt(i) == 57 || password.charAt(i) == 65
                    || password.charAt(i) == 66 || password.charAt(i) == 67 || password.charAt(i) == 68 || password.charAt(i) == 69 || password.charAt(i) == 70 || password.charAt(i) == 71 || password.charAt(i) == 72 || password.charAt(i) == 73 || password.charAt(i) == 74 || password.charAt(i) == 75 || password.charAt(i) == 76 || password.charAt(i) == 77 || password.charAt(i) == 78 || password.charAt(i) == 79 ||
                    password.charAt(i) == 80 || password.charAt(i) == 81 || password.charAt(i) == 82 || password.charAt(i) == 83 || password.charAt(i) == 84 || password.charAt(i) == 85 || password.charAt(i) == 86 || password.charAt(i) == 87 || password.charAt(i) == 88 || password.charAt(i) == 89 || password.charAt(i) == 90 || password.charAt(i) == 97 ||
                    password.charAt(i) == 98 || password.charAt(i) == 99 || password.charAt(i) == 100 || password.charAt(i) == 101 || password.charAt(i) == 102 || password.charAt(i) == 103 || password.charAt(i) == 104 || password.charAt(i) == 105 || password.charAt(i) == 106 || password.charAt(i) == 107 || password.charAt(i) == 108 || password.charAt(i) == 109 || password.charAt(i) == 110 || password.charAt(i) == 111 ||
                    password.charAt(i) == 112 || password.charAt(i) == 113 || password.charAt(i) == 114 || password.charAt(i) == 115 || password.charAt(i) == 116 || password.charAt(i) == 117 || password.charAt(i) == 118 || password.charAt(i) == 119 || password.charAt(i) == 120 || password.charAt(i) == 121 || password.charAt(i) == 122) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
}
