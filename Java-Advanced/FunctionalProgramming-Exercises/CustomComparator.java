import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> allNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> getEvenList = list -> list.stream()
                .filter(n -> n % 2 == 0).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> getOddList = list -> list.stream()
                .filter(n -> n % 2 != 0).collect(Collectors.toList());
        List<Integer> evenList = getEvenList.apply(allNumbers);
        Collections.sort(evenList);
        List<Integer> oddList = getOddList.apply(allNumbers);
        Collections.sort(oddList);

        evenList.stream().forEach(e -> System.out.print(e + " "));
        oddList.stream().forEach(e -> System.out.print(e + " "));
    }
}
