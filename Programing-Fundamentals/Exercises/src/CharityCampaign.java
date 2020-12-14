import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dni = Integer.parseInt(scanner.nextLine());
        int sladkari = Integer.parseInt(scanner.nextLine());
        int torti = Integer.parseInt(scanner.nextLine());
        int gofreti = Integer.parseInt(scanner.nextLine());
        int palachinki = Integer.parseInt(scanner.nextLine());
        double cenaTortri = torti * 45;
        double cenaGofreti = gofreti * 5.80;
        double cenaPalachinki = palachinki * 3.20;
        double cenaSladkari = (cenaTortri + cenaPalachinki + cenaGofreti) * sladkari;
        double sum = cenaSladkari * dni;
        double end = sum - (sum/8) ;
        System.out.printf("%.2f", end);
    }
}
