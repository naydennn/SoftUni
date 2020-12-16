import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = createList(scanner);

        String line = scanner.nextLine();
        while (!line.equals("Craft!")) {
            String[] commands = line.split(" - ");
            String item = commands[1];

            switch (commands[0]) {
                case "Collect":
                    if (!inventory.contains(item)){
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    inventory.remove(item);
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    if (inventory.contains(items[0])) {
                        int index = inventory.indexOf(items[0]);
                        inventory.add(index+1, items[1]);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(item)) {
                        inventory.remove(item);
                        inventory.add(item);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.print(String.join(", ", inventory));
    }
    public static List<String> createList (Scanner scanner) {
        String input = scanner.nextLine();
        String[] array = input.split(", ");

        return new ArrayList<>(Arrays.asList(array));
    }
}
