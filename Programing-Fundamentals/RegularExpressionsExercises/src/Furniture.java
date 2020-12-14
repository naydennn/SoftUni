import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSpendMoney = 0;
        String regex = ">>(?<furniture>[A-z]+)<<(?<price>\\d+\\.*\\d*)!(?<quantity>\\d+)";
        List<String> furniture = new ArrayList<>();


        while (!input.equals("Purchase")) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furniture.add(matcher.group("furniture"));
                totalSpendMoney += Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");

        for (String f : furniture) {
            System.out.println(f);
        }
        System.out.printf("Total money spend: %.2f", totalSpendMoney);
    }
}