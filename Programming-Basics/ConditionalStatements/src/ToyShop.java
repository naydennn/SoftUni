import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyWithDiscount = 0;
        double money = 0;
        double ostatak = 0;
        double cenaNaEkskurziq = Double.parseDouble(scanner.nextLine());
        double numberPuzeli = Double.parseDouble(scanner.nextLine());
        double numberKukli = Double.parseDouble(scanner.nextLine());
        double numberMecheta = Double.parseDouble(scanner.nextLine());
        double numberMinioni = Double.parseDouble(scanner.nextLine());
        double numberKamioni = Double.parseDouble(scanner.nextLine());

        double numberIgrachki = numberKamioni + numberKukli + numberMecheta + numberMinioni + numberPuzeli;
        double cenaIgrachki = (numberKamioni * 2) + (numberKukli * 3) + (numberMecheta * 4.1) + (numberMinioni * 8.2) + (numberPuzeli * 2.6);

        if (numberIgrachki >= 50) {
            moneyWithDiscount = cenaIgrachki - (cenaIgrachki * 0.25);
            money = moneyWithDiscount - (moneyWithDiscount * 0.1);
        } else {
            money =cenaIgrachki -  (cenaIgrachki * 0.1);
        }
        if (money > cenaNaEkskurziq) {
            ostatak = money - cenaNaEkskurziq;
            System.out.printf("Yes! %.2f lv left.", ostatak);
        } else {
            ostatak = Math.abs(money - cenaNaEkskurziq);
            System.out.printf("Not enough money! %.2f lv needed.", ostatak);
        }

    }
}
