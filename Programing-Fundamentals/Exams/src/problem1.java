import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());

        double priceForKgFlour = Double.parseDouble(scanner.nextLine());
        double priceForKgEggs = priceForKgFlour * 0.75;
        double priceForMilk = priceForKgFlour + priceForKgFlour * 0.25;
        priceForMilk *= 0.25;
        double money = 0;
        int count = 0;
        int coloredEgg = 0;


        money += priceForKgEggs + priceForKgFlour + priceForMilk;
        budget -= money;
        while (budget >= 0) {
            count++;
            coloredEgg += 3;
            if (count % 3 == 0) {
                coloredEgg -= count-2;
            }
            budget -= money;
        }
        budget += money;
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.%n", count, coloredEgg,budget );
    }
}
