import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(input));
        int numOfMoves = 0;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            numOfMoves++;
            String[] tokens = command.split(" ");
            int firstIndex = Integer.parseInt(tokens[0]);
            int secondIndex = Integer.parseInt(tokens[1]);
            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex > list.size() || secondIndex < 0 || secondIndex >= list.size()) {
                list.add(list.size() / 2, "-" + numOfMoves + "a");
                list.add(list.size() / 2, "-" + numOfMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (list.get(firstIndex).equals(list.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(firstIndex));
                    if (firstIndex > secondIndex) {
                        list.remove(firstIndex);
                        list.remove(secondIndex);
                    } else {
                        list.remove(secondIndex);
                        list.remove(firstIndex);
                    }
                } else {
                    System.out.println("Try again!");
                }
            }
            if (list.isEmpty()){
                System.out.printf("You have won in %d turns!%n", numOfMoves);
                return;
            }
            command = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(");
        for (String s:list) {
            System.out.print(s + " ");
        }
    }
}
