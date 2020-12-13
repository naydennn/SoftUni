import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String result = getString(text);
        System.out.println(result);
    }
    public static String getString(String text) {
        String characters = "";
        if (text.length() % 2 == 0) {
           characters += text.charAt(text.length() /2 -1);
           characters += text.charAt(text.length()/2);
           return characters;
        }
        characters  += text.charAt(text.length()/2);
        return characters;
    }
}
