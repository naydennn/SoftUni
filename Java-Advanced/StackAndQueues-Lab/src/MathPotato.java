import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name :
                names) {
            queue.offer(name);
        }

        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            boolean isPrime = checkIsPrime(cycle);
            if (isPrime) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + queue.pop());
    }

    private static boolean checkIsPrime(int num) {
        int check;

        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            check = num % 2;
            if (check == 0) {
                return false;
            }
        }
        return true;
    }
}
