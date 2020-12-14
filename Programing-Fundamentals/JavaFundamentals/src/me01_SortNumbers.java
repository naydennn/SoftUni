import java.util.Scanner;

public class me01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        if (number1 > number2 && number1 > number3) {
            System.out.println(number1);
            if (number2 > number3) {
                System.out.println(number2);
                System.out.println(number3);
            } else {
                System.out.println(number3);
                System.out.println(number2);
            }
        }
        if (number2 > number1 && number2 > number3) {
            System.out.println(number2);
            if (number1 > number3) {
                System.out.println(number1);
                System.out.println(number3);
            } else {
                System.out.println(number3);
                System.out.println(number1);
            }
        }
        if (number3 > number2 && number3 > number1) {
            System.out.println(number3);
            if (number1 > number2) {
                System.out.println(number1);
                System.out.println(number2);
            } else {
                System.out.println(number2);
                System.out.println(number1);
            }
        }
    }
}
