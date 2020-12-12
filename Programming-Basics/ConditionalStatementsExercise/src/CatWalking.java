import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minuti = Integer.parseInt(scanner.nextLine());
        int razhodkiDnevno = Integer.parseInt(scanner.nextLine());
        double kalorii = Double.parseDouble(scanner.nextLine());
        double totalMinuti = minuti * razhodkiDnevno;
        double totalKalorii = totalMinuti * 5;
        double prietiKalorii = kalorii / 2;

        if (totalKalorii >= prietiKalorii) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", totalKalorii);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", totalKalorii);
        }
    }
}
