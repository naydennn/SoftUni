import java.util.*;


public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();


        while (!input.equals("Done")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i <password.length() ; i+=2) {
                        newPassword.append(password.charAt(i));
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);
                    String firstPart = password.substring(0, index);
                    String secondPart = password.substring(index + length);
                    password = firstPart + secondPart;
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commands[1];
                    String substitute = commands[2];
                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);

    }
}
