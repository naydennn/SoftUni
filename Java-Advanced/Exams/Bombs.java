import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
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

        int countDaturaBombs = 0;
        int countCherryBombs = 0;
        int countSmokeBombs = 0;


        boolean haveEnoughBombs = false;

        while (!(deque.isEmpty() || stack.isEmpty() || haveEnoughBombs)) {
            int poll = deque.poll();
            int pop = stack.pop();
            int sum = poll + pop;

            switch (sum) {
                case 40:
                    countDaturaBombs++;
                    break;
                case 60:
                    countCherryBombs++;
                    break;
                case 120:
                    countSmokeBombs++;
                    break;
                default:
                    deque.offerFirst(poll);
                    stack.push(pop - 5);
                    break;
            }
            if (countDaturaBombs >=3 && countCherryBombs >= 3 && countSmokeBombs >= 3) {
                haveEnoughBombs = true;
            }
        }
        StringBuilder result = new StringBuilder();
        if (haveEnoughBombs) {
            result.append("Bene! You have successfully filled the bomb pouch!").append(System.lineSeparator());
        } else {
            result.append("You don't have enough materials to fill the bomb pouch.").append(System.lineSeparator());
        }
        if (!deque.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            deque.forEach(e -> sb.append(e).append(", "));
            String substring = sb.substring(0, sb.lastIndexOf(","));
            result.append("Bomb Effects: ").append(substring).append(System.lineSeparator());

        } else {
            result.append("Bomb Effects: empty").append(System.lineSeparator());
        }
        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            stack.forEach(e -> sb.append(e).append(", "));
            String substring = sb.substring(0, sb.lastIndexOf(","));
            result.append("Bomb Casings: ").append(substring).append(System.lineSeparator());
        } else {
            result.append("Bomb Casings: empty").append(System.lineSeparator());
        }

        result.append("Cherry Bombs: ").append(countCherryBombs).append(System.lineSeparator());
        result.append("Datura Bombs: ").append(countDaturaBombs).append(System.lineSeparator());
        result.append("Smoke Decoy Bombs: ").append(countSmokeBombs);
        System.out.print(result.toString());
    }
}
