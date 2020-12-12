import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int shirina = Integer.parseInt(scanner.nextLine());
        int dyljina = Integer.parseInt(scanner.nextLine());
        int visochina  = Integer.parseInt(scanner.nextLine());
        String count = scanner.nextLine();
        double needSpace = shirina * visochina * dyljina;
        double freeSpace = 0;
        double end = 0;

        while (!count.equals("Done")) {
            double freeShirina = Double.parseDouble(count);
            freeSpace += freeShirina;
            if (freeSpace > needSpace) {
                end = freeSpace - needSpace;
                System.out.printf("No more free space! You need %.0f Cubic meters more.", end);
                return;
            }
            count = scanner.nextLine();
        }
        end = needSpace - freeSpace;
        System.out.printf("%.0f Cubic meters left.", end);
    }
}
