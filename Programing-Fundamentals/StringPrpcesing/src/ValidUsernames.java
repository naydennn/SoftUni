import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] usernames = scanner.nextLine().split(", ");
        for (String user : usernames) {
            boolean isValid = true;

            if (user.length() < 3 || user.length() > 16) {
                isValid = false;
            }
            if (isValid) {
                for (int k = 0; k < user.length(); k++) {
                    char symbol = user.charAt(k);
                    if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                System.out.println(user);
            }
        }
    }
}
