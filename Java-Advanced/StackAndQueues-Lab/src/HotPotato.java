import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : names) {
            queue.offer(name);
        }

        int n = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
                if (n == i) {
                    System.out.println("Removed " + queue.poll());
                } else {
                    String name = queue.poll();
                    queue.offer(name);
                }
            }
        }
        System.out.println("Last is " + queue.poll());
    }
}
