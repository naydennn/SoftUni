import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                result.append(text.charAt(i));
            }
        }
        if (text.length()-2 != text.length()-1 ) {
            result.append(text.charAt(text.length()-1 ));
        }
        System.out.println(result);


    }
}
