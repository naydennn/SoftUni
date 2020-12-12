import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budjet = Double.parseDouble(scanner.nextLine());
        String sezon  = scanner.nextLine();
        double money = 0;

        if (budjet <= 100) {
            switch (sezon) {
                case "summer":
                    money = 0.3 * budjet;
                    System.out.printf("Somewhere in Bulgaria %n");
                    System.out.printf("Camp - %.2f", money);
                    break;
                case "winter":
                    money = 0.7 * budjet;
                    System.out.printf("Somewhere in Bulgaria %n");
                    System.out.printf("Hotel - %.2f", money);
                    break;
            }
        } else if (budjet <= 1000) {
            switch (sezon) {
                case "summer":
                    money = 0.4 * budjet;
                    System.out.printf("Somewhere in Balkans %n");
                    System.out.printf("Camp - %.2f", money);
                    break;
                case "winter":
                    money = 0.8 * budjet;
                    System.out.printf("Somewhere in Balkans %n");
                    System.out.printf("Hotel - %.2f", money);
                    break;
            }
        } else if (budjet > 1000) {
            switch (sezon) {
                case "summer":
                case "winter":
                    money = 0.9 * budjet;
                    System.out.printf("Somewhere in Europe %n");
                    System.out.printf("Hotel - %.2f", money);
                    break;
            }
        }
    }
}
