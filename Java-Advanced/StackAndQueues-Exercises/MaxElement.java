import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (commands[0]) {
                case 1:
                    int num = commands[1];
                    stack.push(num);
                    break;
                case 2:
                    stack.poll();
                    break;
                case 3:
                    int max = Integer.MIN_VALUE;
                    for (int number : stack) {
                        if (number > max) {
                            max = number;
                        }
                    }
                    System.out.println(max);
                    break;
            }
        }
    }
}
