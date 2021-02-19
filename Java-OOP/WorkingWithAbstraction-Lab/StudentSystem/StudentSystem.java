import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void addStudent(String[] input) {
        Student student = createStudent(input);

        repo.putIfAbsent(student.getName(), student);
    }

    public void showStudent(String[] input) {
        String name = input[1];

        StringBuilder studentInfo = new StringBuilder();

        if (repo.containsKey(name)) {
            Student student = repo.get(name);

            studentInfo.append(String.format("%s is %s years old.", student.getName(), student.getAge())).append(getCommentary(student));

            PrinterOnConsole.print(studentInfo.toString());
        }
    }

    private String getCommentary(Student student) {
        if (student.getGrade() >= 5.00) {
            return " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            return " Average student.";
        }

        return " Very nice person.";
    }

    private Student createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        return new Student(name, age, grade);
    }
}
