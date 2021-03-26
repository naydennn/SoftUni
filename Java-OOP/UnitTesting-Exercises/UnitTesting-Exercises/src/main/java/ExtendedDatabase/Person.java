package ExtendedDatabase;

public class Person {
    private String name;
    private Long id;

    public Person(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
