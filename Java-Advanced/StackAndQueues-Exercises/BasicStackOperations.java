import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfElements = Integer.parseInt(scanner.next());
        int numToPush = Integer.parseInt(scanner.next());
        int numToContains = Integer.parseInt(scanner.next());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfElements; i++) {
            stack.push(Integer.parseInt(scanner.next()));
        }
        for (int i = 0; i < numToPush; i++) {
            stack.poll();
        }

        int min = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(numToContains)) {
            System.out.println(stack.contains(numToContains));
        } else {
            int size = stack.size();
            for (int i = 0; i <size; i++) {
                if (stack.peek() < min) {
                    min = stack.pop();
                }
            }
            System.out.println(min);
        }
    }
}
