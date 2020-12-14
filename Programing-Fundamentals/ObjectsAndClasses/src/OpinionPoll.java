import java.util.*;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();


        for (int i = 0; i <n ; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            personList.add(person);
        }
        personList.stream().filter(person -> person.getAge() > 30).sorted((p1,p2) ->p1.getName().compareTo(p2.getName())).
        forEach(person -> System.out.println(person));

    }
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", name, age);
        }
    }
}
