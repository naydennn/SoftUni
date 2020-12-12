import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTime = Integer.parseInt(scanner.nextLine());
        int secoundTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());

        int sumTime = firstTime + secoundTime + thirdTime;

        int minuti = sumTime / 60;
        int secound  = sumTime % 60;

        if (secound < 10) {
            System.out.printf("%d:0%d", minuti, secound);
        } else {
            System.out.printf("%d:%d", minuti, secound);
        }
    }
}
