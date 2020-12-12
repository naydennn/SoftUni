import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double enoughMoney = Double.parseDouble(scanner.nextLine());
        double money = Double.parseDouble(scanner.nextLine());
        int daysSpend = 0;
        int counter = 0;

        while (money < enoughMoney && daysSpend < 5) {
            String text = scanner.nextLine();
            double spendOrSaveMoney = Double.parseDouble(scanner.nextLine());
            counter++;
            if (text.equals("spend")) {
                daysSpend++;
                money -= spendOrSaveMoney;
                if (money < 0) {
                    money = 0;
                }
            } else if (text.equals("save")) {
                money += spendOrSaveMoney;
                daysSpend = 0;
            }
        }
        if (money >= enoughMoney) {
            System.out.printf("You saved the money for %d days.", counter);
        } else {
            System.out.printf("You can't save the money.%n%d", counter);
        }

    }
}