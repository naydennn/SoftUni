import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String comand = scanner.nextLine();
        int max = Integer.MIN_VALUE;

        while (!comand.equals("Stop")) {
            int number = Integer.parseInt(comand);
            if (number > max) {
                max = number;
            }
            comand = scanner.nextLine();
        }
        System.out.println(max);
    }
}
