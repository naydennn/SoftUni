import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfWagons = createList(scanner);

        int maxPassengers = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            if (command[0].equals("Add")) {
                int num = Integer.parseInt(command[1]);
                listOfWagons.add(num);
            } else {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i < listOfWagons.size(); i++) {
                    if (listOfWagons.get(i) + passengers <= maxPassengers) {
                        listOfWagons.set(i, listOfWagons.get(i) + passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        printList(listOfWagons);
    }

    private static void printList(List<Integer> listOfWagons) {
        for (int index : listOfWagons) {
            System.out.print(index + " ");
        }
    }


    private static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numberAsString = line.split(" ");

        List<Integer> list = new ArrayList<>();
        for (String index : numberAsString) {
            int num = Integer.parseInt(index);
            list.add(num);
        }
        return list;
    }
}
