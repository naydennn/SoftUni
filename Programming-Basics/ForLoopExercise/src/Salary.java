import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int globa1 = 0;
        int globa2 = 0;
        int globa3 = 0;
        int total = 0;

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();

            if (text.equals("Facebook")) {
                globa1 += 150;
            } else if (text.equals("Instagram")) {
                globa2 += 100;
            } else if (text.equals("Reddit")) {
                globa3 += 50;
            }
            total = (globa1 + globa2 + globa3);
            if (total >= salary) {
                break;
            }
        }
        if (total >= salary) {
            System.out.println("You have lost your salary.");
        } else {
            total = salary - total;
            System.out.println(total);
        }

    }
}
