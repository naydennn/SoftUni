import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    static class Students {
        String firstName;
        String lastName;
        double grade;

        Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f",getFirstName(), getLastName(), getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Students> student = new ArrayList<>();

        for (int i = 0; i <num ; i++) {
            String[] input = scanner.nextLine().split(" ");
            Students stud = new Students(input[0], input[1], Double.parseDouble(input[2]));
            student.add(stud);
        }

        student.stream().sorted((p1, p2) -> Double.compare(p2.getGrade(), p1.getGrade())).forEach(
                stud -> System.out.println(stud));
    }
}
