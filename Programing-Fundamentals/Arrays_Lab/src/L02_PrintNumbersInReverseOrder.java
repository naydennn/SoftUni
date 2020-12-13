import java.util.Scanner;

public class L02_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbersInArray = new int[n];

        for (int i = 0; i < numbersInArray.length ; i++) {
            numbersInArray[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = numbersInArray.length -1; i >= 0 ; i--) {
            System.out.print(numbersInArray[i]+ " ");
        }
    }
}
