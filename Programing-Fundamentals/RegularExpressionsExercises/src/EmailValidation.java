import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        for (String t : text) {
            Pattern pattern = Pattern.compile("\\b(?<email>[a-z]+[\\.\\-\\_]*\\d*\\w*@[a-z]+[\\-]*[a-z]*\\.[a-z]+\\.*[a-z]*)\\b");
            Matcher matcher = pattern.matcher(t);
            if (matcher.find()){
                String email = matcher.group("email");
                System.out.println(email);
            }
        }
    }
}
