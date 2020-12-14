import java.util.Scanner;

public class e01_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        double students = Double.parseDouble(scanner.nextLine());
        double priceOfSabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobe = Double.parseDouble(scanner.nextLine());
        double priceOfBelt = Double.parseDouble(scanner.nextLine());

        double totalSabersNeed = students + (Math.ceil(students * 0.1));
        double freeBelt = Math.floor(students / 6);

        double sum = totalSabersNeed * priceOfSabers + priceOfRobe * students + priceOfBelt * (students - freeBelt);

        if (money >= sum) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            sum = sum - money;
            System.out.printf("Ivan Cho will need %.2flv more.", sum);
        }
    }
}
