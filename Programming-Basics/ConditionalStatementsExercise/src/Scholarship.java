import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dohod = Double.parseDouble(scanner.nextLine());
        double uspeh = Double.parseDouble(scanner.nextLine());
        double zaplata = Double.parseDouble(scanner.nextLine());
        double stipendiq = 0;
        double gradeStipendiq = 0;

        if (dohod <= zaplata && uspeh >= 4.5) {
            stipendiq = Math.floor(zaplata * 0.35);
        }

        if (uspeh >= 5.5 ) {
            gradeStipendiq = Math.floor(uspeh * 25);
        }

        if (gradeStipendiq > stipendiq) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", gradeStipendiq);
        } else if (gradeStipendiq < stipendiq) {
            System.out.printf("You get a Social scholarship %.0f BGN", stipendiq);
        } else {
            System.out.printf("You cannot get a scholarship!");
        }

    }
}

