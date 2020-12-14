import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char firstLetter = s.charAt(0);
            char secondLetter = s.charAt(s.length()-1);
            int digit = Integer.parseInt(s.substring(1, s.length() -1));

            int firstLetterPosition = getAlphabeticPosition(firstLetter);
            int secondLetterPosition = getAlphabeticPosition(secondLetter);

            if (Character.isUpperCase(firstLetter)) {
                sum += (double) digit / firstLetterPosition;
            } else {
                sum += (double)digit * firstLetterPosition;
            }
            if (Character.isUpperCase(secondLetter)) {
                sum -= secondLetterPosition;
            } else {
                sum += secondLetterPosition;
            }
        }

        System.out.printf("%.2f", sum);

    }

    private static int getAlphabeticPosition(char letter) {
        char symbol = Character.toLowerCase(letter);
        return  symbol - 'a' + 1;
    }
}
