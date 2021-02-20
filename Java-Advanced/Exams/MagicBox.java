import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(deque::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        int items = 0;
        while (!(deque.isEmpty()) && !(stack.isEmpty())) {
            int poll = deque.poll();
            int pop = stack.pop();
            int sum = pop + poll;

            if (sum % 2 == 0) {
                items += sum;
            } else {
                deque.addFirst(poll);
                deque.addLast(pop);
            }
        }
        if (deque.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (items >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + items);
        }else {
            System.out.println("Poor prey... Value: " + items);
        }
    }
}
