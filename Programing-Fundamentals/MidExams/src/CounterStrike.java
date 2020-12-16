import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int battleWins = 0;
        String input = scanner.nextLine();


        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance > energy) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", battleWins, energy);
                return;
            } else {
                energy -= distance;
                battleWins++;
                if (battleWins % 3 == 0) {
                    energy += battleWins;
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", battleWins, energy);
    }
}
