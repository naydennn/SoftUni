import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double grade = 0;
        int counter = 1;

        while (counter <= 12) {
            double number = Double.parseDouble(scanner.nextLine());
            if (number < 4) {
                System.out.printf("%s has been excluded at %d grade", name , counter);
                return;
            }
            grade += number;
            counter++;
        }
        grade /= counter - 1;
        System.out.printf("%s graduated. Average grade: %.2f", name , grade);
    }
}
