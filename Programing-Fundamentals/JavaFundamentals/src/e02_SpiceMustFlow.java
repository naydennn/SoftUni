import java.util.Scanner;

public class e02_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int daysCount = 0;
        int leaving = 0;

        if (startingYield < 100) {
            System.out.println(daysCount);
            System.out.println(leaving);
        } else {
            while (startingYield >= 100) {
                daysCount++;
                leaving += startingYield - 26;
                startingYield -= 10;
            }
            leaving -= 26;
            System.out.println(daysCount);
            System.out.println(leaving);
        }
    }
}
