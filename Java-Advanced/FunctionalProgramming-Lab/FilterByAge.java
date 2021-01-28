import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<String, Person> parsePerson = str -> {
            String[] tokens = str.split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            return new Person(name, age);
        };
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            people.add(parsePerson.apply(scanner.nextLine()));
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older") ?
                formatPeople(people, p -> p.age >= ageCondition)
                : formatPeople(people, p -> p.age <= ageCondition);

        System.out.println(printPeople(people, getFunction(format), System.lineSeparator()));
    }

    private static Function<Person, String> getFunction(String format) {
        switch (format) {
            case "name":
                return person -> person.name;
            case "age":
                return person -> String.valueOf(person.age);
            case "name age":
                return person -> person.name + " - " + String.valueOf(person.age);
            default:
                throw new IllegalStateException("Unknown format type " + format);
        }
    }

    public static String printPeople(Collection<Person> people,
                                     Function<Person, String> myFunction,
                                     String delimiter) {
        return people.stream().map(myFunction)
                .collect(Collectors.joining(delimiter));
    }

    public static List<Person> formatPeople(Collection<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate)
                .collect(Collectors.toList());
    }
}
