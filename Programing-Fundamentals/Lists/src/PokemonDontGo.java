import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = createList(scanner);
        int sum = 0;

        while (!list.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int number;
            if (index < 0) {
                number = list.get(0);
                sum += number;
                list.remove(0);
                list.add(0, list.get(list.size() - 1));

                increasingOrDecreasing(list, number);

            } else if (index >= list.size()) {
                number = list.get(list.size() - 1);
                sum += number;
                list.remove(list.size() - 1);
                list.add(list.get(0));

                increasingOrDecreasing(list, number);

            } else {
                number = list.get(index);
                list.remove(index);
                sum += number;

                increasingOrDecreasing(list, number);
            }

        }
        System.out.println(sum);
    }

    private static void increasingOrDecreasing(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= number) {
                list.set(i, list.get(i) + number);
            } else {
                list.set(i, list.get(i) - number);
            }
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
