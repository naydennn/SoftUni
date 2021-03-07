package animals;

public class Tomcat extends Cat{

    public static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
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
