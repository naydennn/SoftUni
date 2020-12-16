import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double totalPrices = 0;
        double taxes;

        while (!(command.equals("special") || command.equals("regular"))) {
            double prices = Double.parseDouble(command);
            if (prices < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPrices += prices;
            }
            command = scanner.nextLine();

        }
        if (totalPrices == 0) {
            System.out.println("Invalid order!");
            return;
        }

        taxes = totalPrices * 0.2;
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", totalPrices);
        System.out.printf("Taxes: %.2f$\n"  +
                "-----------\n", taxes);
        totalPrices+=taxes;
        if (command.equals("special")) {
          totalPrices -=totalPrices * 0.1;
        }
        System.out.printf("Total price: %.2f$", totalPrices);
    }
}
