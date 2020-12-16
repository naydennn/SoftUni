import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n  = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");
            Pattern patternTag = Pattern.compile("^([$%])(?<tag>[A-Z][a-z]{2,})\\1");
            Matcher matcherTag = patternTag.matcher(input[0]);
            Pattern patternNum = Pattern.compile("(?<number>\\d+)");
            Matcher matcherNum = patternNum.matcher(input[1]);
            StringBuilder message = new StringBuilder();
            boolean isValid = false;
            int count = 0;
            while (matcherNum.find()) {
                int num = Integer.parseInt(matcherNum.group("number"));
                message.append((char) num);
                count++;
                if (count <= 3) {
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
            if (matcherTag.find() && isValid) {
                String tag = matcherTag.group("tag");
                System.out.println(tag + ": " + message.toString());
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
