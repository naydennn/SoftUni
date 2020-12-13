import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumber = createList(scanner);
        List<Integer> specialList = createList(scanner);
        int bombNumber = specialList.get(0);
        int powerOfBomb = specialList.get(1);

        while (listOfNumber.contains(bombNumber)) {
            for (int i = powerOfBomb; i >0 ; i--) {
                int indexOfBomb = listOfNumber.indexOf(bombNumber);
                if (indexOfBomb + 1 <= listOfNumber.size()) {
                    listOfNumber.remove(indexOfBomb + 1);
                }
            }
            for (int j = powerOfBomb; j >0 ; j--) {
                int indexOfBomb = listOfNumber.indexOf(bombNumber);
                if (indexOfBomb - 1 >= 0) {
                    listOfNumber.remove(indexOfBomb - 1);
                }
            }
            int indexOfBomb = listOfNumber.indexOf(bombNumber);
            if (indexOfBomb>=0) {
                listOfNumber.remove(indexOfBomb);
            }
        }
        int sum = 0;
        for (int num:listOfNumber) {
            sum += num;
        }
        System.out.println(sum);

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
