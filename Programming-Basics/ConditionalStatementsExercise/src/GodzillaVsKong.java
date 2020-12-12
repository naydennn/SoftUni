import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budjet = Double.parseDouble(scanner.nextLine());
        double broiStatisti = Double.parseDouble(scanner.nextLine());
        double priceObleklo = Double.parseDouble(scanner.nextLine());
        double totalObleklo = broiStatisti * priceObleklo;
        double dekor = budjet * 0.1;
        double discount = 0;
        double money = 0;
        double end = 0;

        if (broiStatisti >= 150 ) {
            discount = totalObleklo - (totalObleklo * 0.1);
            money = discount + dekor;
        } else {
            money = totalObleklo + dekor;
        }

        if (money > budjet) {
            end = Math.abs(budjet - money);
            System.out.printf("Not enough money! %n");
            System.out.printf("Wingard needs %.2f leva more.", end);
        } else if (money <= budjet){
            end = budjet - money;
            System.out.printf("Action! %n");
            System.out.printf("Wingard starts filming with %.2f leva left.", end);
        }

    }
}
