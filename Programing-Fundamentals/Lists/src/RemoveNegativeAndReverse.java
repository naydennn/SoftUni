import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativeAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> linesOfNumbers = createList(scanner);

        List<Integer> nonNegativeNumber = getNonNegativeNumber(linesOfNumbers);
        Collections.reverse(nonNegativeNumber);

        if (nonNegativeNumber.isEmpty()) {
            System.out.println("empty");
        } else {
            for (int number : nonNegativeNumber) {
                System.out.print(number + " ");
            }
        }
    }

    private static List<Integer> getNonNegativeNumber(List<Integer> linesOfNumbers) {
        List<Integer> nonNegativeNumber = new ArrayList<>();
        for (int num : linesOfNumbers) {
            if (num >= 0) {
                nonNegativeNumber.add(num);
            }
        }
        return nonNegativeNumber;
    }


    private static List<Integer> createList(Scanner scanner) {
        List<Integer> lineOfNumbers = new ArrayList<>();
        String line = scanner.nextLine();
        String[] numbersAsString = line.split(" ");

        for (String num : numbersAsString) {
            int number = Integer.parseInt(num);
            lineOfNumbers.add(number);
        }
        return lineOfNumbers;
    }
}
