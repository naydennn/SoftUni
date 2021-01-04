import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            List<Double> grades = students.get(name);
            if (grades == null) {
                grades = new ArrayList<>();
                students.put(name, grades);
            }
            grades.add(grade);
            students.put(name, grades);
        }
        students.forEach((key, value) -> {
            System.out.print(key + " -> ");
            double average = 0;
            for (Double aDouble : value) {
                average += aDouble;
                System.out.printf("%.2f ", aDouble);
            }
            average /= value.size();
            System.out.printf("(avg: %.2f)%n", average);
        });
    }
}
