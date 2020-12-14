import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static class Persons {
        String name;
        String id;
        int age;

        public Persons(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Persons> personInfo = new ArrayList<>();

        while (!input.equals("End")) {
            String[] info = input.split(" ");
            Persons person = new Persons(info[0], info[1], Integer.parseInt(info[2]));
            personInfo.add(person);

            input = scanner.nextLine();
        }
        personInfo.stream().sorted((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge())).forEach(persons -> System.out.println(persons));
    }
}
