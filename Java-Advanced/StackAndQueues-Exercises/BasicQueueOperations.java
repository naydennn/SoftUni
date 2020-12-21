import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfElements = Integer.parseInt(scanner.next());
        int numToRemove = Integer.parseInt(scanner.next());
        int numToCheck = Integer.parseInt(scanner.next());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numOfElements; i++) {
            queue.offer(Integer.parseInt(scanner.next()));
        }
        for (int i = 0; i < numToRemove; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(numToCheck)) {
            System.out.println(queue.contains(numToCheck));
        } else {
            int min = Integer.MAX_VALUE;
            for (int n : queue) {
                if (n < min) {
                    min = n;
                }
            }
            System.out.println(min);
        }
    }
}
