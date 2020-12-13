import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = createList(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split("\\s+");
            String number = commands[1];

            switch (commands[0]) {
                case "Delete":
                    while (list.contains(number)) {
                        list.remove(number);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    if (index < list.size()){
                        list.add(index, number);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printList(list);
    }

    private static void printList(List<String> list) {
        for (String num : list) {
            System.out.print(num + " ");
        }
    }

    private static List<String> createList(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numberAsString = line.split("\\s+");

        List<String> list = new ArrayList<>();
        for (String index : numberAsString) {
            list.add(index);
        }
        return list;
    }
}
