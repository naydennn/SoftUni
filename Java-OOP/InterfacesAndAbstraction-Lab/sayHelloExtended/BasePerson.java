package sayHello;

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
