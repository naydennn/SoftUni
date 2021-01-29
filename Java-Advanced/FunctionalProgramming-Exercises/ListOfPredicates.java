import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endOfBound = Integer.parseInt(scanner.nextLine());

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        IntPredicate predicate = n ->{
            boolean isValid = false;
            for (int divider : numbers) {
                 if (n % divider == 0){
                     isValid = true;
                 } else {
                    isValid = false;
                    break;
                 }
            }
            return isValid;
        };
        IntStream.range(1, endOfBound + 1).filter(predicate)
                .forEach(e-> System.out.print(e + " "));

    }
}
