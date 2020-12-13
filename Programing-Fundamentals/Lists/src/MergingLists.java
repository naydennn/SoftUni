import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = createList(scanner);
        List<Integer> secondList = createList(scanner);

        List<Integer> numbers = new ArrayList<>();

        int index = 0;
        while (index < firstList.size()  || index < secondList.size()) {
            if (index < firstList.size()) {
                numbers.add(firstList.get(index));
            }
            if (index < secondList.size()) {
                numbers.add(secondList.get(index));
            }
            index++;
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
