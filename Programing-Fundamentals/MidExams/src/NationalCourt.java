import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peoplePerHour = 0;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            peoplePerHour += num;
        }
        int questions = Integer.parseInt(scanner.nextLine());

        int time = 0;
        int countToBreak = 0;

        while (questions > 0) {
            questions -= peoplePerHour;
            time++;
            countToBreak++;
            if (countToBreak == 4) {
                time++;
                countToBreak = 1;
            }
        }
        System.out.printf("Time needed: %dh.", time);
    }
}
