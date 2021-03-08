package foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> buyers = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {
                buyers.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]),
                        tokens[2], tokens[3]));
            } else {
                buyers.add(new Rebel(tokens[0], Integer.parseInt(tokens[1]),
                        tokens[2]));
            }
        }

        List<String> nameOfBuyers = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            nameOfBuyers.add(input);

            input = scanner.nextLine();
        }
    }
}
