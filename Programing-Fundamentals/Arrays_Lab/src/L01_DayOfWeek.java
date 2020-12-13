import java.util.Scanner;

public class L01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        String[] dayOfWeek = new String[7];
        dayOfWeek[0] = "Monday";
        dayOfWeek[1] = "Tuesday";
        dayOfWeek[2] = "Wednesday";
        dayOfWeek[3] = "Thursday";
        dayOfWeek[4] = "Friday";
        dayOfWeek[5] = "Saturday";
        dayOfWeek[6] = "Sunday";

        if (day >= 1 && day <=7) {
            System.out.println(dayOfWeek[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
