import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double countOfLectures = Double.parseDouble(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        double totalBonus;
        int studentAttendances = 0;

        for (int i = 0; i < countOfStudents; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());

            totalBonus = Math.round(attendances / countOfLectures * (5 + bonus));
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                studentAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", studentAttendances);
    }
}
