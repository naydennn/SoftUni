package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int compare = this.name.compareTo(other.name);
        if (compare == 0) {
            compare = Integer.compare(this.age, other.age);
            if (compare == 0) {
                compare = this.town.compareTo(other.town);
            }
        }
        return compare;
    }
}
