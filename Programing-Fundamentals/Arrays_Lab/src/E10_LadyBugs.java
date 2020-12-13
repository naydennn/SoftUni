import java.util.Scanner;

public class E10_LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] fieldSize = new int[n];

        String[] indexOfLadyBugs = scanner.nextLine().split(" ");

        for (int i = 0; i < indexOfLadyBugs.length; i++) {
            int bugIndex = Integer.parseInt(indexOfLadyBugs[i]);

            if (bugIndex >= 0 && bugIndex < fieldSize.length) {
                fieldSize[bugIndex] = 1;
            }
        }

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] command = line.split(" ");
            int flightBugs = Integer.parseInt(command[0]);
            String direction = command[1];
            int ladybug = Integer.parseInt(command[2]);

            if (flightBugs < 0 || flightBugs >= fieldSize.length || fieldSize[flightBugs] != 1) {
                line = scanner.nextLine();
                continue;
            }

            fieldSize[flightBugs] = 0;

            if (direction.equals("right")) {
                flightBugs += ladybug;

                while (flightBugs < fieldSize.length && fieldSize[flightBugs] == 1) {
                    flightBugs += ladybug;
                }
                if (flightBugs < fieldSize.length) {
                    fieldSize[flightBugs] = 1;
                }
            } else {
                flightBugs -= ladybug;
                while (flightBugs >= 0 && fieldSize[flightBugs] == 1) {
                    flightBugs -= ladybug;
                }
                if (flightBugs >= 0) {
                    fieldSize[flightBugs] = 1;
                }
            }
            line = scanner.nextLine();
        }
        for (int i = 0; i < fieldSize.length; i++) {
            System.out.print(fieldSize[i] + " ");
        }

    }
}

