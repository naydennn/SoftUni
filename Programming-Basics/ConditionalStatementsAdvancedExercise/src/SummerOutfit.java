import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gradusi = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        String outfit = "";
        String shoes = "";

        if (gradusi >= 10 && gradusi <= 18) {
            switch (time) {
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Afternoon":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
            }
        } else if (gradusi > 18 && gradusi <= 24) {
            switch (time) {
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
            }
        } else if (gradusi >= 25) {
            switch (time) {
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    System.out.printf("It's %d degrees, get your %s and %s.", gradusi, outfit, shoes);
                    break;
            }
        }
    }
}