import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int broiStranici = Integer.parseInt(scanner.nextLine());
        int stranici = Integer.parseInt(scanner.nextLine());
        int dni = Integer.parseInt(scanner.nextLine());
        int result = (broiStranici / stranici) / dni;
        System.out.println(result);
    }
}
