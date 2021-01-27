import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Function<String, Long> getCount = str -> Arrays.stream(str.split(", "))
                .mapToInt(Integer::parseInt).count();
        Function<String, Integer> getSum = str -> Arrays.stream(str.split(", "))
                .mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + getCount.apply(line));
        System.out.println("Sum = " + getSum.apply(line));

    }
}
