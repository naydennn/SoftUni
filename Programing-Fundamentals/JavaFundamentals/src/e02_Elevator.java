import java.util.Scanner;

public class e02_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = scanner.nextInt();
        int courses = scanner.nextInt();
        int result = 0;

        if (people > courses) {
            if (people % courses == 0) {
                result = people / courses;
            } else {
                result = people / courses;
                result += 1;
            }
            System.out.println(result);
        } else {
            System.out.println("1");
        }

    }
}
