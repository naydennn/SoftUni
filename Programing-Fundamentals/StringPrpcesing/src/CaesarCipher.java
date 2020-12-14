import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char chars = (char) (text.charAt(i) + 3);
            s.append(chars);
        }
        System.out.println(s.toString());
    }
}
