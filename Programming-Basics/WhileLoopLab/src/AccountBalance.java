import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String balance = scanner.nextLine();
        double sum = 0;

        while (!balance.equals("NoMoreMoney")) {
            double money = Double.parseDouble(balance);

            if (money < 0) {
                System.out.printf("Invalid operation!%n");
                break;
            }
            System.out.printf("Increase: %.2f%n", money);
            sum += money;
            balance = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }
}
