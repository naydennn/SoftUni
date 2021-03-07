package animals;

public class Cat extends Animal{

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
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
