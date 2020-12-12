import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceRaketa = Double.parseDouble(scanner.nextLine());
        int raketi = Integer.parseInt(scanner.nextLine());
        int shoes = Integer.parseInt(scanner.nextLine());

        double totalRaketa = priceRaketa * raketi;
        double totalShoes = (priceRaketa / 6.0 ) * shoes;
        double other = (totalRaketa + totalShoes) * 0.2;
        double total = totalRaketa + totalShoes + other;
        double priceNovak = Math.floor(total / 8.0);
        double otherPrice = Math.ceil(total - priceNovak);

        System.out.printf("Price to be paid by Djokovic %.0f %n", priceNovak);
        System.out.printf("Price to be paid by sponsors %.0f %n", otherPrice);
    }
}
