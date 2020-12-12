import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pen = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double literPreparat = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double totalSum = (pen * 5.80) + (markers * 7.20) + (literPreparat * 1.20);
        double end = totalSum - (totalSum * discount / 100);

        System.out.printf("%.3f", end);
    }
}
