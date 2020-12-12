import java.util.Scanner;

public class Paswword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        String secoundPassword = scanner.nextLine();

        while (!secoundPassword.equals(password)) {
            secoundPassword = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", username);
    }
}
