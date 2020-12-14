import java.util.Scanner;

public class e01_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfPerson = scanner.nextLine();
        String typeOfDay = scanner.nextLine();
        double price = 0;
        double discount = 0;

        if (typeOfDay.equals("Friday")) {
            switch (typeOfPerson) {
                case "Students":
                    price = numberOfPeople * 8.45;
                    break;
                case "Business":
                    price = numberOfPeople * 10.9;
                    discount = 10 * 10.9;
                    break;
                case "Regular":
                    price = numberOfPeople * 15;
                    break;
            }
        } else if (typeOfDay.equals("Saturday")) {
            switch (typeOfPerson) {
                case "Students":
                    price = numberOfPeople * 9.8;
                    break;
                case "Business":
                    price = numberOfPeople * 15.6;
                    discount = 10 * 15.6;
                    break;
                case "Regular":
                    price = numberOfPeople * 20;
                    break;
            }

        } else if (typeOfDay.equals("Sunday")) {
            switch (typeOfPerson) {
                case "Students":
                    price = numberOfPeople * 10.46;
                    break;
                case "Business":
                    price = numberOfPeople * 16;
                    discount = 10 * 16;
                    break;
                case "Regular":
                    price = numberOfPeople * 22.50;
                    break;
            }
        }
        if (numberOfPeople >= 30 && numberOfPeople < 100 && typeOfPerson.equals("Students")) {
            price -= price * 0.15;
        } else if (numberOfPeople >=100 && typeOfPerson.equals("Business")) {
            price -= discount;
        } else if (numberOfPeople >= 10 && numberOfPeople <= 20 && typeOfPerson.equals("Regular")) {
            price -= price * 0.05;
        }

        System.out.printf("Total price: %.2f", price);
    }
}
