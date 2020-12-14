import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        int result = 0;

        if (times > 10) {
            result = number * times;
            System.out.printf("%d X %d = %d%n", number, times, result);
        }

        for (int i = times; i <= 10 ; i++) {
            result = number * i;
            System.out.printf("%d X %d = %d%n", number, i, result);
        }

    }
}
