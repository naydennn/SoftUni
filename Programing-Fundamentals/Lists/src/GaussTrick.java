import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = createList(scanner);

       int index = 0;

       while (index < numbers.size() - 1) {
           numbers.set(index, numbers.get(index) + numbers.get(numbers.size()- 1) );
           numbers.remove(numbers.size() - 1);
           index++;
       }

        for (int num : numbers) {
            System.out.print(num + " ");
        }

    }

    public static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsString = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : lineAsString) {
            Integer number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
