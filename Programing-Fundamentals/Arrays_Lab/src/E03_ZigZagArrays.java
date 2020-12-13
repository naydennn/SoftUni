import java.util.Scanner;

public class E03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            if (i % 2 != 0) {
                firstArray[i] = array[0];
                secondArray[i] = array[1];
            } else {
                secondArray[i] = array[0];
                firstArray[i] = array[1];
            }
        }
        for (int i = 0; i <n ; i++) {
            System.out.print(secondArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n ; i++) {
            System.out.print(firstArray[i] + " ");
        }


    }
}
