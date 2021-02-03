import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
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

         int sumOfClaimedItems = 0;

         while (!(deque.isEmpty() || stack.isEmpty())) {

             if ((deque.peek() + stack.peek()) % 2 == 0) {
                 sumOfClaimedItems += deque.poll() + stack.pop();
             } else {
                 deque.offerLast(stack.pop());
             }
         }
        if (deque.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (sumOfClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumOfClaimedItems);
        }
    }
}
