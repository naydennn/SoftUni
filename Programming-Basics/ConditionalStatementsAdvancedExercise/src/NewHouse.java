import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flower = scanner.nextLine();
        int numberFlower = Integer.parseInt(scanner.nextLine());
        int budjet = Integer.parseInt(scanner.nextLine());
        double total = 0;
        double end = 0;
        double money = 0;

        switch (flower) {
            case "Roses":
                total = 5;
                break;
            case "Dahlias":
                total = 3.8;
                break;
            case "Tulips":
                total = 2.8;
                break;
            case "Narcissus":
                total = 3;
                break;
            case "Gladiolus":
                total = 2.5;
                break;
        }
        end = total * numberFlower;

        if (numberFlower > 80 && flower.equals("Roses")) {
            end = end - 0.1 * end;
        } else if (numberFlower > 90 && flower.equals("Dahlias")) {
            end = end - 0.15 * end;
        } else if (numberFlower > 80 && flower.equals("Tulips")) {
            end = end - 0.15 * end;
        } else if (numberFlower < 120 && flower.equals("Narcissus")) {
            end = end + 0.15 * end;
        } else if (numberFlower < 80 && flower.equals("Gladiolus")) {
            end = end + 0.2 * end;
        }

        if ( budjet >= end ) {
            money = budjet - end;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberFlower, flower, money );
        } else if (budjet < end) {
            money = end - budjet;
            System.out.printf("Not enough money, you need %.2f leva more.", money);
        }

    }
}
