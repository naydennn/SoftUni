
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRooms = 0;
        int health = 100;
        int bitcoins = 0;

        String[] dungeonsRooms = scanner.nextLine().split("\\|");

        for (String dungeonsRoom : dungeonsRooms) {
            String[] everyRoom = dungeonsRoom.split(" ");
            int token = Integer.parseInt(everyRoom[1]);
            numberOfRooms++;

            switch (everyRoom[0]) {
                case "potion":
                    health += token;
                    if (health > 100) {
                        token -= health - 100;
                        health = 100;

                    }
                    System.out.printf("You healed for %d hp.%n", token);
                    System.out.printf("Current health: %d hp.%n", health);

                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", token);
                    bitcoins += token;
                    break;
                default:
                    String monster = everyRoom[0];
                    health -= token;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", numberOfRooms);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d", health);
    }
}
