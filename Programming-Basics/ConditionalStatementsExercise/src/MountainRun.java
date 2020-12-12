import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record  = Double.parseDouble(scanner.nextLine());
        double meter = Double.parseDouble(scanner.nextLine());
        double secondsInMeter = Double.parseDouble(scanner.nextLine());
        double end = 0;

        double totalMeter = meter * secondsInMeter;
        double slow = Math.floor(meter / 50) * 30;
        double totalTime = slow + totalMeter;

        if (totalTime >= record) {
            end = totalTime - record;
            System.out.printf("No! He was %.2f seconds slower.", end);
        } else {
            System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
        }

    }
}
