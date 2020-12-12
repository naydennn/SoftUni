import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double pricePeralnq = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());
        double gift = 0;
        double toys = 0;
        double brother = 0;
        double money = 0;
        double end = 0;

        for (int i = 1; i <= age ; i++) {
            if (i % 2 == 0) {
                gift += (i * 5);
                brother += 1;
            } else {
                toys += priceToy;
            }
        }
        money = toys + gift - brother;
        if (money >= pricePeralnq) {
            end = money - pricePeralnq;
            System.out.printf("Yes! %.2f", end);
        } else {
            end = pricePeralnq - money;
            System.out.printf("No! %.2f", end);
        }
    }
}
