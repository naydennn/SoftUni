import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double large = Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());
        double totalTime = large * time;
        double timeSlower = Math.floor(large / 15) * 12.5;
        double total = totalTime + timeSlower;
        double end = 0;

        if (record <= total) {
            end = Math.abs(record - total);
            System.out.printf("No, he failed! He was %.2f seconds slower.", end);
        } else {
            end = total;
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", end);
        }

    }
}
