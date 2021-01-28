import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        String condition = scanner.nextLine();

        int[] numbers = IntStream.range(lowerBound, upperBound + 1)
                .filter(getPredicate(condition)).toArray();


        Arrays.stream(numbers).mapToObj(n -> n + " ").forEach(System.out::print);
    }

    private static IntPredicate getPredicate(String condition) {
        return  condition.equals("even") ? p -> p % 2 == 0 :
                p -> p % 2 != 0;
    }
}
