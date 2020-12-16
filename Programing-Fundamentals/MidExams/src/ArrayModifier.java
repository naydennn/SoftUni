import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = getIntArray(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "swap" -> swapIndex(numbers, commands);
                case "multiply" -> multiplyIndex(numbers, commands);
                case "decrease" -> decreaseArray(numbers);
            }

            input = scanner.nextLine();
        }
        printArray(numbers);
    }

    private static void decreaseArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] - 1;
        }
    }

    private static void multiplyIndex(int[] numbers, String[] commands) {
        int first = Integer.parseInt(commands[1]);
        int second = Integer.parseInt(commands[2]);
        int multiplyElement = numbers[first] * numbers[second];
        numbers[first] = multiplyElement;
    }

    private static void swapIndex(int[] numbers, String[] commands) {
        int firstElement = Integer.parseInt(commands[1]);
        int secondElement = Integer.parseInt(commands[2]);
        int oldFirstElement = numbers[firstElement];
        numbers[firstElement] = numbers[secondElement];
        numbers[secondElement] = oldFirstElement;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1) {
                System.out.print(numbers[i] + ", ");
            } else {
                System.out.print(numbers[i]);
            }
        }
    }

    private static int[] getIntArray(Scanner scanner) {
        String[] arrayAsString = scanner.nextLine().split(" ");
        int[] numbers = new int[arrayAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrayAsString[i]);
        }
        return numbers;
    }
}
