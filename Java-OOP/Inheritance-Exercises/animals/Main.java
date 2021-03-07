package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!input.equals("Beast!")) {

            String[] tokens = scanner.nextLine().split("\\s+");

            switch (input) {
                case "Cat":
                    animals.add(new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
                case "Dog":
                    animals.add(new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
                case "Frog":
                    animals.add(new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
                    break;
            }

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
