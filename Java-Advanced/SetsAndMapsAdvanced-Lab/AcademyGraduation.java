import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> graduations = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            double average = 0;
            for (double num : scores) {
                average += num;
            }
            average /= scores.length;
            graduations.put(name, average);
        }
        graduations.forEach((key, value) -> System.out.printf("%s is graduated with "
                + value + "%n", key));

    }
}
