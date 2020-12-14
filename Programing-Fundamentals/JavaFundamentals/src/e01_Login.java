import java.util.Scanner;

public class e01_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        int count = 0;

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }

        while (count < 4) {
            String login = scanner.nextLine();

            if (login.equals(password)) {
                System.out.printf("User %s logged in.", username);
                return;
            } else if (count < 3) {
                System.out.println("Incorrect password. Try again.");
            }
            count++;
        }
        System.out.printf("User %s blocked!", username);
    }
}
