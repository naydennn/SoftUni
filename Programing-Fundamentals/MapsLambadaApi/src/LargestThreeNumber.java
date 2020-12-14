import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list =Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).sorted(Comparator.reverseOrder()).limit(3)
                .collect(Collectors.toList());

            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }

