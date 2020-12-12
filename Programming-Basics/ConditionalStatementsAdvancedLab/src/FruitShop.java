import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double total =Double.parseDouble(scanner.nextLine());
        double price = 0;

        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday")) {
            switch (fruit){
                case "banana":
                    price = total * 2.5;
                    System.out.printf("%.2f", price);
                    break;
                case "apple":
                    price = total * 1.2;
                    System.out.printf("%.2f", price);
                    break;
                case "orange":
                    price = total * 0.85;
                    System.out.printf("%.2f", price);
                    break;
                case "grapefruit":
                    price = total * 1.45;
                    System.out.printf("%.2f", price);
                    break;
                case "kiwi":
                    price = total * 2.7;
                    System.out.printf("%.2f", price);
                    break;
                case "pineapple":
                    price = total * 5.5;
                    System.out.printf("%.2f", price);
                    break;
                case "grapes":
                    price = total * 3.85;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (day.equals("Saturday") || day.equals("Sunday")) {
            switch (fruit) {
                case "banana":
                    price = total * 2.7;
                    System.out.printf("%.2f", price);
                    break;
                case "apple":
                    price = total * 1.25;
                    System.out.printf("%.2f", price);
                    break;
                case "orange":
                    price = total * 0.9;
                    System.out.printf("%.2f", price);
                    break;
                case "grapefruit":
                    price = total * 1.6;
                    System.out.printf("%.2f", price);
                    break;
                case "kiwi":
                    price = total * 3.0;
                    System.out.printf("%.2f", price);
                    break;
                case "pineapple":
                    price = total * 5.6;
                    System.out.printf("%.2f", price);
                    break;
                case "grapes":
                    price = total * 4.2;
                    System.out.printf("%.2f", price);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }

    }
}
