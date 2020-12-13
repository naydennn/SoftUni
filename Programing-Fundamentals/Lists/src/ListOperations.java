import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = createList(scanner);
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    int number = Integer.parseInt(commands[1]);
                    list.add(number);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    int num = Integer.parseInt(commands[1]);
                    if (index < 0 || index >= list.size()) {
                        System.out.println("Invalid index");
                    } else {
                        list.add(index, num);
                    }
                    break;
                case "Remove":
                    int i = Integer.parseInt(commands[1]);
                    if (i >= list.size() || i < 0) {
                        System.out.println("Invalid index");
                    } else {
                        list.remove(i);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(commands[2]);
                    if (commands[1].equals("left")) {
                        shiftToLeft(list, count);
                    } else if (commands[1].equals("right")) {
                        shiftToRight(list, count);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printList(list);
    }

    private static void shiftToLeft(List<Integer> list, int count) {

        for (int i = 0; i < count; i++) {
            int temp = list.get(0);
            for (int j = 0; j <list.size() - 1; j++) {
                list.set(j, list.get(j + 1));
            }
            list.set(list.size() - 1, temp);
        }

    }

    private static void shiftToRight(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            int temp = list.get(list.size() - 1);
            for (int j = list.size() - 1; j > 0; j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(0, temp);
        }


    }

    private static void printList(List<Integer> list) {
        for (int numbers : list) {
            System.out.print(numbers + " ");
        }
    }

    public static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsString = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : lineAsString) {
            Integer number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
