import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (double n : values) {
            numbers.putIfAbsent(n,0);
            numbers.put(n, numbers.get(n) + 1);
        }

        numbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
