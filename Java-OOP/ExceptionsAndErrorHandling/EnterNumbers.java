import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int[] numbers = validateNumber(scanner);
                printNumbers(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printNumbers(int[] numbers) {
        for (int i = numbers[0]; i < numbers[1] ; i++) {
            System.out.println(i);
        }
    }

    private static int[] validateNumber(Scanner scanner) {
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[2];
        if (start < 1 || start >= end || end > 100) {
            throw new IllegalArgumentException("Invalid Start and End numbers." +
                    "Numbers must be: end: 1 < start < end < 100.");
        }
        numbers[0] = start;
        numbers[1] = end;
        return numbers;
    }
}
