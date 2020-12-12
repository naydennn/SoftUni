
import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double savings = 0;

            while (savings < budget) {
                savings += Double.parseDouble(scanner.nextLine());
            }

            System.out.printf("Going to %s!%n", input);
            input = scanner.nextLine();
        }
    }
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String comand = scanner.nextLine();
//        int money = 0;
//
//        while (!comand.equals("End")) {
//            double budjet = Double.parseDouble(scanner.nextLine());
//            for (int i = money; i <= budjet ; i++) {
//                double input = Double.parseDouble(scanner.nextLine());
//                money += input;
//                if (money >= budjet) {
//                    System.out.printf("Going to %s!%n", comand);
//                    break;
//                }
//            }
//            money = 0;
//                comand = scanner.nextLine();
//        }
//    }
//}
