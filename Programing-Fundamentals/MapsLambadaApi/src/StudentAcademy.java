
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name  = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            List<Double> grades = studentsInfo.get(name);
            if (grades == null) {
                grades = new ArrayList<>();
                studentsInfo.put(name, grades);
            }
            grades.add(grade);
            studentsInfo.put(name,grades);
        }
        studentsInfo.entrySet().stream()
                .filter(s ->  s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.5)
                .sorted((f,s) -> {
                    double first = f.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second, first);
                }).forEach(s -> System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));

    }
}
