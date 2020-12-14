import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    double cenaQgodi = Double.parseDouble(scanner.nextLine());
    double bananni = Double.parseDouble(scanner.nextLine());
    double portokali = Double.parseDouble(scanner.nextLine());
    double malini = Double.parseDouble(scanner.nextLine());
    double qgodi = Double.parseDouble(scanner.nextLine());
    double cenaMalini = cenaQgodi - (cenaQgodi * 50 / 100);
    double cenaPortokali = cenaMalini - (cenaMalini * 40 / 100);
    double cenaBanani = cenaMalini - (cenaMalini * 80 /100);
    double sumMalini = malini * cenaMalini;
    double sumPortokali = portokali * cenaPortokali;
    double sumBanani = bananni * cenaBanani;
    double sumQgodi = qgodi * cenaQgodi;
    double sum = sumBanani + sumMalini + sumPortokali + sumQgodi;
    System.out.printf("%.2f", sum);


    }
}
