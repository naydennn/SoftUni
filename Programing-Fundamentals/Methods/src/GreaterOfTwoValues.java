import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        if (text.equals("int")) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());
            int result = getMax(firstNum, secondNum);
            System.out.println(result);
        } else if (text.equals("char")) {
            char firstSymbol = scanner.nextLine().charAt(0);
            char secondSymbol = scanner.nextLine().charAt(0);
            char result = getMax(firstSymbol, secondSymbol);
            System.out.println(result);
        } else {
            String firstString = scanner.nextLine();
            String secondString = scanner.nextLine();
            String result = getMax(firstString, secondString);
            System.out.println(result);
        }
    }

    public static int getMax(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    public static char getMax(char first, char second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    public static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}
