import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Predicate<String> predicate = str -> str != null
                && !str.isEmpty() && Character.isUpperCase(str.charAt(0));

        List<String> list = Arrays.stream(line.split("\\s+"))
                .filter(predicate).collect(Collectors.toList());

        System.out.println(list.size());

        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
