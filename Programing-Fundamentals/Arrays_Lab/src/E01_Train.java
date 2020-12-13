import java.util.Scanner;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfWagons = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[countOfWagons];
        int sum = 0;

        for (int i = 0; i <wagons.length ; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
            sum += wagons[i];
        }

        for (int i = 0; i <wagons.length ; i++) {
            System.out.print(wagons[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
