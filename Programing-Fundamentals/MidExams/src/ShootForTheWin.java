
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] shotTargets = getIntArray(scanner);
        int countOfShotTarget = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < shotTargets.length) {

                if (shotTargets[index] != -1) {
                    int number = shotTargets[index];
                    shotTargets[index] = -1;
                    countOfShotTarget++;

                    increaseOrDecraseNumbers(shotTargets, number);
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countOfShotTarget);
        for (int n:shotTargets){
            System.out.print(n + " ");
        }
    }

    private static void increaseOrDecraseNumbers(int[] shotTargets, int number) {
        for (int i = 0; i < shotTargets.length; i++) {
            if (shotTargets[i] != -1 && shotTargets[i] > number) {
                shotTargets[i] -= number;
            } else if (shotTargets[i] != -1 && shotTargets[i] <= number) {
                shotTargets[i] += number;
            }
        }
    }

    private static int[] getIntArray(Scanner scanner) {
        String[] shotTargetsAsString = scanner.nextLine().split(" ");
        int[] shotTargets = new int[shotTargetsAsString.length];
        for (int i = 0; i < shotTargets.length; i++) {
            shotTargets[i] = Integer.parseInt(shotTargetsAsString[i]);
        }
        return shotTargets;
    }
}
