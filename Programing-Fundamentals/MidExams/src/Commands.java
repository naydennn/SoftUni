
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Commands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] resultingArray = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "reverse":
                    reverseArrays(resultingArray, command);
                    break;
                case "sort":
                    int index = Integer.parseInt(command[2]);
                    int end = Integer.parseInt(command[4]);
                    sortArrays(resultingArray, index, end);
                    break;
                case "remove":
                    int removeIndex = Integer.parseInt(command[1]) -1;
                    List<String> list = new ArrayList<>(Arrays.asList(resultingArray));
                    for (int i = removeIndex; i >=0; i--) {
                        list.remove(i);
                    }
                    resultingArray = new String [list.size()];
                    for (int i = 0; i <resultingArray.length ; i++) {
                        resultingArray[i] = list.get(i);
                    }

            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", resultingArray));
    }

    private static void reverseArrays(String[] resultingArray, String[] command) {
        int start = Integer.parseInt(command[2]);
        int count = Integer.parseInt(command[4]);
        String[] reverse = new String[count];
        for (int i = 0; i <count ; i++) {
            reverse[i] = resultingArray[start+i];
        }
        for (int i = 0; i <reverse.length/2 ; i++) {
            String temp = reverse[i];
            reverse[i] = reverse[reverse.length-1-i];
            reverse[reverse.length-1-i] = temp;
        }
        for (int i = 0; i <count ; i++) {
            resultingArray[start+i] = reverse[i];
        }
    }

    private static void sortArrays(String[] resultingArray, int index, int end) {

        for (int i = index; i < index + end; i++) {
            for (int j = i + 1; j < index + end; j++) {
                int first = Integer.parseInt(resultingArray[i]);
                int second = Integer.parseInt(resultingArray[j]);
                if (first > second) {
                    String k = resultingArray[i];
                    resultingArray[i] = resultingArray[j];
                    resultingArray[j] = k;
                }
            }
        }
    }
}
