import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking {
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

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!(stack.isEmpty() || deque.isEmpty())) {
            int pop = stack.pop();
            int poll = deque.poll();
            int sum  = poll + pop;
            switch (sum) {
                case 25:
                    bread++;
                    break;
                case 50:
                    cake++;
                    break;
                case 75:
                    pastry++;
                    break;
                case 100:
                    fruitPie++;
                    break;
                default:
                    stack.push(pop + 3);
                    break;
            }
        }
        if (bread ==0 || cake == 0 || pastry == 0 || fruitPie == 0) {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        } else {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        if (!deque.isEmpty()) {
            String result = deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + result);
        } else {
            System.out.println("Liquids left: none");
        }
        if (!stack.isEmpty()) {
            String result = stack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + result);
        } else {
            System.out.println("Ingredients left: none");
        }
        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
