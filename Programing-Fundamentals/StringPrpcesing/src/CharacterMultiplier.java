import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.next();
        String second = scanner.next();
        int result = 0;
        if (first.length() >= second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (i < second.length()) {
                    result += first.charAt(i) * second.charAt(i);
                } else {
                    result += first.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < second.length(); i++) {
                if (i < first.length()) {
                    result += second.charAt(i) * first.charAt(i);
                } else {
                    result+=second.charAt(i);
                }

            }
        }
        System.out.println(result);
    }
}
