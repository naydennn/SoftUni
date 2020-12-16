import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("(U\\$)(?<username>[A-Z][a-z]{2,})\\1(P@\\$)(?<pass>[A-Za-z]{5,}\\d+)\\3");
        int countOfSuccessfulRegistration = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                countOfSuccessfulRegistration++;
                String username = matcher.group("username");
                String pass = matcher.group("pass");
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", username, pass);
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + countOfSuccessfulRegistration);
    }
}
