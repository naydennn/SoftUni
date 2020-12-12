import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kontrola = Integer.parseInt(scanner.nextLine());
        int secondsKontrola = Integer.parseInt(scanner.nextLine());
        double large = Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());

        double minuti = kontrola * 60 + secondsKontrola;
        double slow = large / 120;
        double slowTime = slow * 2.5;
        double tottalTime = (large / 100) * time - slowTime;
        double end = 0;

        if (tottalTime > minuti){
            end  = tottalTime - minuti;
            System.out.printf("No, Marin failed! He was %.3f second slower.", end);
        } else {
            System.out.printf("Marin Bangiev won an Olympic quota! %n ");
            System.out.printf("His time is %.3f.", tottalTime);
        }
    }
}
