import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder result = new StringBuilder(line);
        int strength = 0;

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '>') {
                strength+= Integer.parseInt(String.valueOf(result.charAt(i +1)));
            }
            if (strength > 0 && result.charAt(i) !='>') {
                result.deleteCharAt(i);
                i--;
                strength--;
            }
        }
        System.out.println(result);
    }
}
