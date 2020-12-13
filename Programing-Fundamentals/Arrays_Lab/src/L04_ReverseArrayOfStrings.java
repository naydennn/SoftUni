import java.util.Scanner;

public class L04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] arrayOfString = line.split(" ");

        String[] array = new String[arrayOfString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayOfString[i];
        }

        for (int i = 0; i < array.length / 2; i++) {
            String leftIndex = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = leftIndex;
        }
        System.out.println(String.join(" ", array));
    }
}
