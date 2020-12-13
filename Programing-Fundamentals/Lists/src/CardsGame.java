import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = createList(scanner);
        List<Integer> secondPlayer = createList(scanner);

        while (firstPlayer.size() >0 && secondPlayer.size() > 0) {
            int firstPlayerCard = firstPlayer.get(0);
            int secondPlayerCard = secondPlayer.get(0);

            if (firstPlayerCard == secondPlayerCard) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else {
                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayerCard);
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            }
        }
        int sum = 0;
        if (firstPlayer.size() == 0){
            for (int num: secondPlayer) {
               sum+=num;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            for (int num: firstPlayer) {
                sum+=num;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }

    private static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numberAsString = line.split("\\s+");

        List<Integer> list = new ArrayList<>();
        for (String index : numberAsString) {
            int num = Integer.parseInt(index);
            list.add(num);
        }
        return list;
    }
}
