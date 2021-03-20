package ValidPerson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Franco", "Aimee", 19);

        try {
            Person noName = new Person("  ", "Aimee", 19);
        }catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
        try {
            Person noLastName = new Person("Franco", null, 19);
        } catch (NumberFormatException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
        try {
            Person negativeAge = new Person("Franco", "Aimee", -1);
        } catch (NumberFormatException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
        try {
            Person toOldPerson = new Person("Franco", "Aimee", 121);
        }catch (NumberFormatException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }


    }
}
