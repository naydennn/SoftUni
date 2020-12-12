import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guest = Integer.parseInt(scanner.nextLine());
        double cuvert = Double.parseDouble(scanner.nextLine());
        double budjet = Double.parseDouble(scanner.nextLine());

        double torta = budjet * 0.1;
        double discount = 0;
        double total = 0;
        double end = 0;

        if (guest >= 10 && guest <= 15) {
            discount = cuvert - (cuvert * 0.15);
            total = guest * discount + torta;
        } else if (guest >= 15 && guest <= 20) {
            discount = cuvert - (cuvert * 0.2);
            total = guest * discount + torta;
        } else if (guest > 20) {
            discount = cuvert - (cuvert * 0.25);
            total = (guest * discount) + torta;
        } else {
            total = guest * cuvert + torta;
        }

        if (total >= budjet) {
            end = total - budjet;
            System.out.printf("No party! %.2f leva needed.", end);
        } else {
            end = Math.abs(total - budjet);
            System.out.printf("It is party time! %.2f leva left.", end);
        }
    }
}
