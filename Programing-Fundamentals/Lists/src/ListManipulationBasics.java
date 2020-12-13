import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = createList(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int number = Integer.parseInt(command[1]);

            switch (command[0]) {
                case "Add":
                    numbers.add(number);
                    break;
                case "Remove":
                    numbers.remove((Object)number);
                    break;
                case "RemoveAt":
                    numbers.remove(number);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numbers.add(index,number);
                    break;
            }
            input = scanner.nextLine();
        }

        printList(numbers);
    }

    public static void printList(List<Integer> numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsString = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : lineAsString) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
