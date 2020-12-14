import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events =  {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        for (int i = 0; i <n ; i++) {
            int pos1 = rnd.nextInt(phrases.length);
            int pos2 = rnd.nextInt(events.length);
            int pos3 = rnd.nextInt(authors.length);
            int pos4 = rnd.nextInt(cities.length);
            System.out.printf("%s %s %s - %s%n",phrases[pos1], events[pos2], authors[pos3], cities[pos4]);
        }
    }
}
