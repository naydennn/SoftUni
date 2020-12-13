import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ME1_Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;

        for (int i = 0; i <number.length ; i++) {
            sum += number[i];
        }

        sum = sum / number.length;
        int leftIndex = 0;
        for (int i = 0; i <number.length ; i++) {
            for (int j = i+1; j <number.length ; j++) {
                if (number[i] > sum) {
                    leftIndex = number[i];
                    number[i] = number[j];
                    number[j] = leftIndex;
                }
            }

        }
        for (int j = 0; j <=number.length - 1 ; j++) {
            System.out.print(number[j] + " ");
        }
    }
}
