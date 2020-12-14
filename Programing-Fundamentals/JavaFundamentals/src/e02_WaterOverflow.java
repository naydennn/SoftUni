import java.util.Scanner;

public class e02_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int maxCapacity = 255;
        int capacity = 0;

        for (int i = 1; i <= n ; i++) {
            int liters = scanner.nextInt();
            capacity += liters;

           if (capacity > maxCapacity){
               capacity -= liters;
                System.out.println("Insufficient capacity!");
            }
        }

            System.out.println(capacity);

    }
}
