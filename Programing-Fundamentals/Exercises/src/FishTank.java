import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int large = Integer.parseInt(scanner.nextLine());
        int shirochina = Integer.parseInt(scanner.nextLine());
        int visochina = Integer.parseInt(scanner.nextLine());
        double procent = Double.parseDouble(scanner.nextLine());
        double obem = large * shirochina * visochina;
        double litri = obem * 0.001;
        double Procent = procent * 0.01;
        double end = litri * (1-Procent);
        System.out.printf("%.2f", end);
    }
}
