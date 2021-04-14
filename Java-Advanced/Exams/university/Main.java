package university;

public class Main {
    public static void main(String[] args) {

        University university = new University(2);

        Student student = new Student("John", "Smith", "Astrology");
        Student studentTwo = new Student("Anna", "Cameron", "Geometry");
        Student studentThree = new Student("Samy", "Johnson", "Algebra");
        Student studentFour = new Student("Rihanna", "Fenty", "Music");
        Student studentFive = new Student("Ellie", "Goulding", "Music");

        System.out.println(university.registerStudent(student));
        System.out.println(university.registerStudent(studentTwo));
        System.out.println(university.registerStudent(studentTwo));
        System.out.println(university.registerStudent(studentThree));

    }
}
