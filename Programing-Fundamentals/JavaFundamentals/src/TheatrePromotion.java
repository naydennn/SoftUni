import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfTheDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age >= 0 && age <=18) {
            switch (typeOfTheDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }
        } else if (age > 18 && age <= 64) {
            switch (typeOfTheDay) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }
        } else if (age > 64 && age <= 122) {
            switch (typeOfTheDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }
        } else {
            System.out.println("Error!");
            return;
        }
        System.out.printf("%s$", price);
    }
}
