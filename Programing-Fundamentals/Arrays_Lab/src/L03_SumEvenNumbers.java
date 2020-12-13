import java.util.Scanner;

public class L03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbersArray = scanner.nextLine();
        String[] number = numbersArray.split(" ");
        int[] num = new int[number.length];
        int sum = 0;

        for (int i = 0; i < number.length ; i++) {
            num[i] = Integer.parseInt(number[i]);
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                sum += num[i];
            }
        }
        System.out.println(sum);
    }
}
