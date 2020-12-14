import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> counts = new TreeMap<>();
        for (double n:num) {
            if (!counts.containsKey(n)) {
                counts.put(n, 0);
            }
            counts.put(n, counts.get(n) + 1);
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
