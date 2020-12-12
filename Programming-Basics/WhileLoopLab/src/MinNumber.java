
import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String comand = scanner.nextLine();
        int min = Integer.MAX_VALUE;

        while (!comand.equals("Stop")) {
            int number = Integer.parseInt(comand);
            if (number < min) {
                min = number;
            }
            comand = scanner.nextLine();
        }
        System.out.println(min);
    }
}

