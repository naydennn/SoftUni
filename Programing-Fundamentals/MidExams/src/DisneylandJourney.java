import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double journeyPrice = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double saveMoney = 0;

        for (int i = 1; i <= months; i++) {
            if (i % 2 != 0 && i != 1) {
                saveMoney -= saveMoney * 0.16;
            }
            if (i % 4 == 0) {
                saveMoney += saveMoney * 0.25;
            }
            saveMoney += journeyPrice * 0.25;
        }
        if (saveMoney > journeyPrice) {
            saveMoney -= journeyPrice;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", saveMoney);
        } else {
            saveMoney = journeyPrice - saveMoney;
            System.out.printf("Sorry. You need %.2flv. more.", saveMoney);
        }
    }
}
