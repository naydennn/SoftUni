import java.util.Scanner;

public class Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfBiscuits = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        int factoryProduces = Integer.parseInt(scanner.nextLine());
        double biscuit = 0;

        for (int i = 0; i <30 ; i++) {
            if (i%3 == 0) {
                    biscuit += Math.floor(((amountOfBiscuits * countOfWorkers) * 0.75));
            } else {
                biscuit += amountOfBiscuits * countOfWorkers;
            }
        }
        System.out.printf("You have produced %.0f biscuits for the past month.%n", biscuit);
        if (biscuit > factoryProduces) {
            biscuit = biscuit - factoryProduces;
            biscuit = biscuit/factoryProduces *100;
            System.out.printf("You produce %.2f percent more biscuits.%n",biscuit);
        } else {
            biscuit = factoryProduces - biscuit;
            biscuit = biscuit/factoryProduces*100;
            System.out.printf("You produce %.2f percent less biscuits.%n", biscuit);
        }

    }
}
