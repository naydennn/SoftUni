import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = createList(scanner);

        int count = 0;

        while (count < numbers.size() - 1) {
            if (numbers.get(count).equals(numbers.get(count + 1))) {
                numbers.set(count, numbers.get(count) + numbers.get(count + 1));
                numbers.remove(count + 1);
                count = 0;
            } else {
                count++;
            }

        }
        for (double list : numbers) {
            System.out.print(new DecimalFormat("#.##").format(list) + " ");
        }
    }

    public static List<Double> createList(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsString = line.split(" ");
        List<Double> numbers = new ArrayList<>();
        for (String s : lineAsString) {
            double number = Double.parseDouble(s);
            numbers.add(number);
        }
        return numbers;
    }
}
