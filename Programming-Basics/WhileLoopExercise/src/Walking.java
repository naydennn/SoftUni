import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int allSteps = 0;
        int krachki = 0;
        int step = 0;

        while (allSteps <= 10000) {
            String steps = scanner.nextLine();

            if (steps.equals("Going home")) {
                krachki = Integer.parseInt(scanner.nextLine());
                allSteps += krachki;
                break;
            }
            step = Integer.parseInt(steps);
            allSteps += step;


        }
        if (allSteps >= 10000) {
            allSteps -= 10000;
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", allSteps);
        } else {
            allSteps = 10000 - allSteps;
            System.out.printf("%d more steps to reach goal.", allSteps);
        }
    }
}
