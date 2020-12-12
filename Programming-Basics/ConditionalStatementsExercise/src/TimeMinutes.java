
import java.util.Scanner;

public class TimeMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minuti = Integer.parseInt(scanner.nextLine());
        int totalMinuti = hour * 60 + minuti + 15;

        hour = totalMinuti / 60;
        minuti = totalMinuti % 60;

        if (hour > 23) {
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, minuti);

    }
}
