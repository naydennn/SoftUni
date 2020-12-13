import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        int guest = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (count < guest) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");
            String name = commands[0];

            switch (commands[2]) {
                case "going!":
                    if (list.contains(name)) {
                        System.out.printf("%s is already in the list!%n", name);
                    } else {
                        list.add(name);
                    }
                    break;
                case "not":
                    if (list.contains(name)) {
                        list.remove(name);
                    } else {
                        System.out.printf("%s is not in the list!%n", name);
                    }
                    break;
            }
            count++;
        }
        for (String guests : list) {
            System.out.println(guests);
        }
    }
}
