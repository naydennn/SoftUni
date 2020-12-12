import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fairGrade = Integer.parseInt(scanner.nextLine());
        String nameOfProblem = scanner.nextLine();
        String lastProblem = "";
        int counter = 0;
        int fail = 0;
        double averageScore = 0;

        while (!nameOfProblem.equals("Enough")) {
           double grade = Double.parseDouble(scanner.nextLine());
            averageScore += grade;
            counter++;
            if (grade <= 4) {
                fail++;
            }
            if (fail >=fairGrade) {
                System.out.printf("You need a break, %d poor grades.", fail);
                return;
            }
            lastProblem = nameOfProblem;
            nameOfProblem = scanner.nextLine();

        }
        averageScore = averageScore / counter;
        System.out.printf("Average score: %.2f%n", averageScore);
        System.out.printf("Number of problems: %d%n", counter);
        System.out.printf("Last problem: %s%n", lastProblem);

    }
}
