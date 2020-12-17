import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] listToArray = scanner.nextLine().split("!");
        List<String> list = Arrays.stream(listToArray).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");
            String item = commands[1];
            switch (commands[0]) {
                case "Urgent":
                    if (!list.contains(item)) {
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    list.remove(item);
                    break;
                case "Correct":
                    String newItem = commands[2];
                    if (list.contains(item)) {
                        int index = list.indexOf(item);
                        list.remove(item);
                        list.add(index,newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)) {
                        list.remove(item);
                        list.add(item);
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", list));
    }
}
