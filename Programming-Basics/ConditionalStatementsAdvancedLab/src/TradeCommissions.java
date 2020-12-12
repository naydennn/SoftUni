import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double ceil = Double.parseDouble(scanner.nextLine());
        double total = 0;

        if (ceil >= 0 && ceil <= 500) {
            switch (city) {
                case "Sofia":
                    total = ceil * 5 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Varna":
                    total = ceil * 4.5 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Plovdiv":
                    total = ceil * 5.5 / 100;
                    System.out.printf("%.2f", total);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (ceil > 500 && ceil <= 1000) {
            switch (city) {
                case "Sofia":
                    total = ceil * 7 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Varna":
                    total = ceil * 7.5 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Plovdiv":
                    total = ceil * 8 / 100;
                    System.out.printf("%.2f", total);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (ceil > 1000 && ceil <= 10000) {
            switch (city) {
                case "Sofia":
                    total = ceil * 8 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Varna":
                    total = ceil * 10 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Plovdiv":
                    total = ceil * 12 / 100;
                    System.out.printf("%.2f", total);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (ceil > 10000) {
            switch (city) {
                case "Sofia":
                    total = ceil * 12 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Varna":
                    total = ceil * 13 / 100;
                    System.out.printf("%.2f", total);
                    break;
                case "Plovdiv":
                    total = ceil * 14.5 / 100;
                    System.out.printf("%.2f", total);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
}
