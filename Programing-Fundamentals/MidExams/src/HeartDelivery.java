
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhood = getIntArray(scanner);
        String input = scanner.nextLine();
        int index = 0;

        while (!input.equals("Love!")) {
            String[] commands = input.split(" ");
            int lengthOfJump = Integer.parseInt(commands[1]);

            if ("Jump".equals(commands[0])) {
                index += lengthOfJump;
                if (index >= neighborhood.length) {
                    index = 0;
                }
                if (neighborhood[index] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", index);
                } else {
                    neighborhood[index] = neighborhood[index] - 2;
                    if (neighborhood[index] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", index);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);

        int failed = getFailed(neighborhood);
        if (failed == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", failed);
        }
    }

    private static int getFailed(int[] neighborhood) {
        int failed = 0;
        for (int n : neighborhood) {
            if (n != 0) {
                failed++;
            }
        }
        return failed;
    }

    private static int[] getIntArray(Scanner scanner) {
        String[] numberAsString = scanner.nextLine().split("@");
        int[] neighborhood = new int[numberAsString.length];
        for (int i = 0; i < numberAsString.length; i++) {
            neighborhood[i] = Integer.parseInt(numberAsString[i]);
        }
        return neighborhood;
    }
}
