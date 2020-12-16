import java.util.*;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = createList(scanner);

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");

            String item = commands[1];
            switch (commands[0]) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    if (shoppingList.contains(item)) {
                        int index = shoppingList.indexOf(item);
                        shoppingList.add(index, commands[2]);
                        shoppingList.remove(item);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));

    }

    public static List<String> createList(Scanner scanner) {
        String[] line = scanner.nextLine().split("!");

        return new ArrayList<>(Arrays.asList(line));
    }
}
