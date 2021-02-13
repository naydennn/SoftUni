package bakery;

public class Employee {
    private String name;
    private int age;
    private String county;

    public Employee(String name, int age, String county) {
        this.name = name;
        this.age = age;
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", this.name, this.age, this.county);
    }
}
