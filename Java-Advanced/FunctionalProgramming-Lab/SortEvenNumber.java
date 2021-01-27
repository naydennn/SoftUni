import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SortEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0).toArray();

        System.out.println(formatArr(numbers));
        Arrays.sort(numbers);
        System.out.println(formatArr(numbers));
    }
    public static String formatArr(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
