import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budjet = Integer.parseInt(scanner.nextLine());
        String sezon = scanner.nextLine();
        int ribari = Integer.parseInt(scanner.nextLine());
        double boat = 0;
        double totalMoney = 0;

        switch (sezon) {
            case "Spring":
                boat = 3000;
                break;
            case "Summer":
            case "Autumn":
                boat = 4200;
                break;
            case "Winter":
                boat = 2600;
                break;
        }
        if (ribari <= 6) {
            boat = boat - boat *0.1;
        } else if (ribari > 7 && ribari <= 11 ) {
            boat = boat - boat * 0.15;
        } else if (ribari > 12) {
            boat = boat - boat * 0.25;
        }

        if (ribari % 2 == 0 ) {
            switch (sezon) {
                case "Spring":
                case "Summer":
                case "Winter":
                    boat = boat - boat *0.05;
                    break;
            }

        }

        if (budjet >= boat) {
            totalMoney = budjet - boat;
            System.out.printf("Yes! You have %.2f leva left.", totalMoney);
        } else if (budjet < boat) {
            totalMoney = boat - budjet;
            System.out.printf("Not enough money! You need %.2f leva.", totalMoney);
        }

    }
}
