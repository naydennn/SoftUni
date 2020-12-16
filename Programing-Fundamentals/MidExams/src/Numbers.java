import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = getNumbers(scanner);
        List<Integer> greaterNumbers = new ArrayList<>();

        int sumOfNumbers = 0;

        for (int value : numbers) {
            sumOfNumbers += value;
        }
        double averageNumber = (double) sumOfNumbers / numbers.length;

        for (int number : numbers) {
            if (number > averageNumber) {
                greaterNumbers.add(number);
            }
        }
        if (greaterNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(greaterNumbers);
            Collections.reverse(greaterNumbers);
            printGreaterNumbers(greaterNumbers);
        }
    }

    private static void printGreaterNumbers(List<Integer> greaterNumbers) {
        for (int i = 0; i < greaterNumbers.size(); i++) {
            if (i < 5) {
                System.out.print(greaterNumbers.get(i) + " ");
            }
        }
    }

    private static int[] getNumbers(Scanner scanner) {
        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        return numbers;
    }
}
