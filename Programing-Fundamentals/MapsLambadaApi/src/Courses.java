import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> students = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" : ");
            String courseName = commands[0];
            String studentName = commands[1];

            List<String> student = students.computeIfAbsent(courseName, k -> new ArrayList<>());
            student.add(studentName);
            students.put(courseName, student);

            input = scanner.nextLine();
        }
        students.entrySet().stream().sorted((a,b) -> b.getValue().size()-a.getValue().size())
                .forEach(a -> {System.out.println(a.getKey() + ": " + a.getValue().size());
        a.getValue().stream().sorted(Comparator.naturalOrder())
                .forEach(p -> System.out.printf("-- %s%n",p)); });
    }
}
