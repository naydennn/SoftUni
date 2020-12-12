import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kid = 0;
        int student = 0;
        int standard = 0;
        int totalTickets = 0;
        int soldTicketsPerMovie = 0;

        String movie = scanner.nextLine();
        int freeSeats = Integer.parseInt(scanner.nextLine());

        while (!movie.equals("Finish")) {


            if (movie.equals("End") || soldTicketsPerMovie > freeSeats) {
                break;
            } else if (movie.equals("kid")){
                kid++;
            } else if (movie.equals("student")) {
                student++;
            } else if (movie.equals("standard")) {
                standard++;
            }
            soldTicketsPerMovie++;
            movie = scanner.nextLine();
        }
    }
}
