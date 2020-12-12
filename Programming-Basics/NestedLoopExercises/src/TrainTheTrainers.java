import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int judje = Integer.parseInt(scanner.nextLine());
        String present  = scanner.nextLine();
        double finalScore = 0;
        int counter = 0;

        while (!present.equals("Finish")) {
            double averageGrade = 0;
            for (int i = 1; i <= judje; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                averageGrade += grade;

            }
            counter++;
            averageGrade = averageGrade / judje;
            finalScore +=averageGrade;
            System.out.printf("%s - %.2f.%n", present, averageGrade);
            present = scanner.nextLine();
        }
        finalScore = finalScore / counter;
        System.out.printf("Student's final assessment is %.2f.", finalScore);
    }
}
