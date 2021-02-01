package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            people.add(person);

            input = scanner.nextLine();
        }
        int countOfEqualPeople = 1;

        int index = Integer.parseInt(scanner.nextLine()) -1;
        Person person = people.get(index);
        for (int i = 0; i <people.size() ; i++) {
            if (i != index) {
                int compare = person.compareTo(people.get(i));
                if (compare == 0) {
                    countOfEqualPeople++;
                }
            }

        }
        if (countOfEqualPeople != 1) {
            System.out.printf("%d %d %d", countOfEqualPeople, people.size() - countOfEqualPeople, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
