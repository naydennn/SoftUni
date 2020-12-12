import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projekciq = scanner.nextLine();
        int redowe = Integer.parseInt(scanner.nextLine());
        int koloni = Integer.parseInt(scanner.nextLine());
        double total = 0;

        if (projekciq.equals("Premiere")) {
            total = koloni * redowe * 12;
        } else if (projekciq.equals("Normal")) {
            total = koloni * redowe * 7.5;
        } else if (projekciq.equals("Discount")) {
            total = koloni * redowe * 5;
        }

        System.out.printf("%.2f", total);
    }
}
