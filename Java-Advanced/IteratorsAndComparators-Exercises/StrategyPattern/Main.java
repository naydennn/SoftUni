package StrategyPattern;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> peopleByName = new TreeSet<>(new ComparatorPerson());
        TreeSet<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }
        peopleByName.forEach(getConsumer());
        peopleByAge.forEach(getConsumer());
    }

    public static Consumer<Person> getConsumer() {
        return n -> System.out.println(n.toString());
    }
}
