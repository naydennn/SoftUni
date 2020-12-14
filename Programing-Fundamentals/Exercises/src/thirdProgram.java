import java.util.Scanner;

public class thirdProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // сума = депозирана сума  + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
        double Deposit = Double.parseDouble(scanner.nextLine());
        int Srok = Integer.parseInt(scanner.nextLine());
        double Procent = Double.parseDouble(scanner.nextLine());
        double Sum = Deposit + Srok * (((Deposit * Procent) / 100 ) / 12);
        System.out.println(Sum);
    }

}
