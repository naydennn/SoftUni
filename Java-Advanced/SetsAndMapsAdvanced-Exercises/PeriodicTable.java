import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");

            for (String chemical : inputs) {
                set.add(chemical);
            }
        }
        for (String s :set) {
            System.out.print(s + " ");
        }
    }
}
