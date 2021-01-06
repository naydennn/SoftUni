import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nAndM = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = nAndM[0];
        int m = nAndM[1];

        Set<Integer> firstSet = getSet(n, scanner);
        Set<Integer> secondSet = getSet(m, scanner);

        for (int num :firstSet) {
            if (secondSet.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }

    private static Set<Integer> getSet(int n, Scanner scanner) {
        Set<Integer>  set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set.add(num);
        }
        return set;
    }
}
