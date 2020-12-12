import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int shirina = Integer.parseInt(scanner.nextLine());
        int dyljina = Integer.parseInt(scanner.nextLine());
        int total = shirina * dyljina;
        String comand = scanner.nextLine();
        int pieces = 0;

        while (!comand.equals("STOP")){

            int totalPieces = Integer.parseInt(comand);
            pieces += totalPieces;
            if (pieces >= total){
                break;
            }

            comand = scanner.nextLine();

        }
        if (comand.equals("STOP")) {
            pieces = total - pieces;
            System.out.printf("%d pieces are left.", pieces);
        } else {
            pieces = pieces - total;
            System.out.printf("No more cake left! You need %d pieces more.", pieces);
        }
    }
}
