import java.util.Scanner;

public class E04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int topElement = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < topElement; i++) {
            String firstElement = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;
        }

        for (String lastArray : array) {
            System.out.print(lastArray + " ");
        }
    }
}
