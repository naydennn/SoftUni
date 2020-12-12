import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mouth = scanner.nextLine();
        int night = Integer.parseInt(scanner.nextLine());
        double priceApartament = 0;
        double priceStudio = 0;

        switch (mouth) {
            case "May":
            case "October":
                priceStudio = night * 50;
                priceApartament = night * 65;
                if (night <= 7 ) {
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }else if (night > 7 && night < 14) {
                    priceStudio = priceStudio - priceStudio * 0.05;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    priceApartament = priceApartament - priceApartament * 0.1;
                    priceStudio = priceStudio - priceStudio * 0.3;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }
                break;
            case "June":
            case "September":
                priceStudio = night * 75.2;
                priceApartament = night * 68.7;
                if (night > 14) {
                    priceStudio = priceStudio - priceStudio * 0.2;
                    priceApartament = priceApartament - priceApartament * 0.1;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }
                break;
            case "July":
            case "August":
                priceStudio = night * 76;
                priceApartament = night * 77;
                if (night > 14) {
                    priceApartament = priceApartament - priceApartament * 0.1;
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", priceApartament);
                    System.out.printf("Studio: %.2f lv.", priceStudio);
                }

                break;

        }
    }
}
