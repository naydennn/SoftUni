import java.util.Scanner;

public class L07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] arraysAsString = line.split(" ");
        int[] number = new int[arraysAsString.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(arraysAsString[i]);
        }

        int i = 0;
        int finalResult = 0;
        int[] condensed = new int[number.length - 1];
        for (int j = 0; j <number.length ; j++) {

            condensed[i] = number[i] + number[i + 1];
            finalResult = condensed[0];
            i++;
        }

        System.out.println(finalResult);
    }
}
