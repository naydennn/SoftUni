import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String repeatedString = scanner.nextLine();
        int numberOfRepeat = Integer.parseInt(scanner.nextLine());

        String result = repeatedString(repeatedString, numberOfRepeat);
        System.out.println(result);
    }

    public static String repeatedString(String repeatedString, int numberOfRepeat) {
        String result = "";
        for (int i = 1; i <= numberOfRepeat; i++) {
            result += repeatedString;
        }
        return result;
    }
}
