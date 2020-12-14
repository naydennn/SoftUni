import java.util.Scanner;

public class L06_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3 ; i++) {
            String input = scanner.nextLine();
            char firstLetter = input.charAt(0);
            System.out.print(firstLetter);
        }
    }
}
