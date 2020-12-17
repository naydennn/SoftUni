import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Change":
                    String paintingNumber = commands[1];
                    String changedNumber = commands[2];
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i].equals(paintingNumber)) {
                            numbers[i] = changedNumber;
                            break;
                        }
                    }
                    break;
                case "Hide":
                    paintingNumber = commands[1];
                    List<String> list = Arrays.stream(numbers).collect(Collectors.toList());
                    list.remove(paintingNumber);
                    numbers = list.toArray(new String[0]);
                    break;
                case "Switch":
                    paintingNumber = commands[1];
                    String paintingNumber2 = commands[2];
                    int first = -1;
                    int second = -1;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i].equals(paintingNumber)) {
                            first = i;
                        }
                        if (numbers[i].equals(paintingNumber2)) {
                            second = i;
                        }
                    }
                    if (first != -1 && second != -1) {
                        numbers[first] = paintingNumber2;
                        numbers[second] = paintingNumber;
                    }
                    break;
                case "Insert":
                    int place = Integer.parseInt(commands[1]);
                    paintingNumber = commands[2];
                    list = Arrays.stream(numbers).collect(Collectors.toList());
                    if (place+1 < numbers.length) {
                        list.add(place+1, paintingNumber);
                        numbers = list.toArray(new String[0]);
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < numbers.length /2; i++) {
                        String temp = numbers[i];
                        numbers[i] = numbers[numbers.length -1 - i];
                        numbers[numbers.length - 1 - i] = temp;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
}
