import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        String result = getCharacterInRange(firstSymbol,secondSymbol);
        System.out.println(result);
    }
    public static String getCharacterInRange(char first, char second) {
        String result = "";
        if (first < second) {
            for (int i = first + 1; i < second; i++) {
                result += (char) i + " ";
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                result += (char) i + " ";
            }
        }
        return result;
    }
}
