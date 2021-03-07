package animals;

public class Kitten extends Cat{

    public static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s",super.getName(),super.getAge(), super.getGender())).append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }
}
