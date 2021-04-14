import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(deque::offer);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        int bouquets = 0;
        int laterSum = 0;

        while (!(stack.isEmpty() || deque.isEmpty())) {
            int daffodils = deque.peek();
            int tulips = stack.peek();
            int sum = daffodils + tulips;

            if (sum == 15) {
                stack.pop();
                deque.poll();
                bouquets++;
            } else if (sum > 15) {
                stack.pop();
                tulips-=2;
                stack.push(tulips);
            } else {
                laterSum += sum;
                stack.pop();
                deque.poll();
            }
        }
        if (laterSum >15){
            bouquets += laterSum / 15;
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);

        }else {
            bouquets = 5 - bouquets;
            System.out.printf("You failed... You need more %d bouquets.", bouquets);
        }
    }
}
