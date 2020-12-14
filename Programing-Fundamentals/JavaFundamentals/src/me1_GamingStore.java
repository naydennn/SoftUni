import java.util.Scanner;

public class me1_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentSpent = 0;
        double totalMoney = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                    if (totalMoney >= 39.99) {
                        totalMoney -= 39.99;
                        currentSpent += 39.99;
                        System.out.println("Bought OutFall 4");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (totalMoney >= 15.99) {
                        totalMoney -= 15.99;
                        currentSpent += 15.99;
                        System.out.println("Bought CS: OG");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "Zplinter Zell":
                    if (totalMoney >= 19.99) {
                        totalMoney -= 19.99;
                        currentSpent += 19.99;
                        System.out.println("Bought Zplinter Zell");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (totalMoney >= 59.99) {
                        totalMoney -= 59.99;
                        currentSpent += 59.99;
                        System.out.println("Bought Honored 2");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (totalMoney >= 29.99) {
                        totalMoney -= 29.99;
                        currentSpent += 29.99;
                        System.out.println("Bought RoverWatch");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if (totalMoney >= 39.99) {
                        totalMoney -= 39.99;
                        currentSpent += 39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (totalMoney <= 0) {
                System.out.println("Out of money!");
                return;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", currentSpent, totalMoney);
    }
}
