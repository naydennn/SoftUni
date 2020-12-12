import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ocenka = Integer.parseInt(scanner.nextLine());

        if (ocenka >= 5) {
            System.out.println("Excellent!");
        }
    }
}
