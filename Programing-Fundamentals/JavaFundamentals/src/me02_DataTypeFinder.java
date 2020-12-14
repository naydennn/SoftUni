import java.util.Scanner;

public class me02_DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                                            // Not ready
        String input = scanner.nextLine();
        char character = Character.MIN_VALUE;
        int count = 0;
        boolean floatingPoint = true;
        boolean string = true;

        while (!input.equals("END")) {

            for (int i = 0; i < input.length(); i++) {
                character = input.charAt(i);
                if (character == 46) {
                    floatingPoint = false;
                }
                if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                    string = false;
                }
                count++;
            }
            if (count == 1) {
                if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                    System.out.printf("%s is character type%n", input);
                } else if (character >= 48 && character <= 57) {
                    System.out.printf("%s is integer type%n", input);
                } else {
                    System.out.printf("%s is character type%n", input);
                }
            } else {
                if (input.equals("true") || input.equals("false")) {
                    System.out.printf("%s is boolean type%n", input);
                } else if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                    System.out.printf("%s is string type%n", input);
                } else if (floatingPoint && character >= 48 && character <= 57) {
                    System.out.printf("%s is integer type%n", input);
                } else if (!string) {
                    System.out.printf("%s is string type%n", input);
                }else if (!floatingPoint && character >= 48 && character <= 57) {
                    System.out.printf("%s is floating point type%n", input);
                } else {
                    System.out.printf("%s is character type%n", input);
                }
            }
            input = scanner.nextLine();
        }
    }
}
