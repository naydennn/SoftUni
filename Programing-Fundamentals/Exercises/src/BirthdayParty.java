import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int naem = Integer.parseInt(scanner.nextLine());
        double torta = naem * 20 / 100;
        double napitki = (torta - (torta *0.45));
        double animator = naem /3;
        double sum = naem + torta + napitki + animator;
        System.out.println(sum);
    }
}
