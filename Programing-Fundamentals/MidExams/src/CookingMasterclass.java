import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfFlour = Double.parseDouble(scanner.nextLine());
        double priceOfEgg = Double.parseDouble(scanner.nextLine());
        double priceOfApron = Double.parseDouble(scanner.nextLine());

        int freeFlour = 0;
        for (int i = 1; i <=students ; i++) {
            if (i%5 == 0){
                freeFlour++;
            }
            }
        double apron = Math.ceil(students + students*0.2);
        double flour = students-freeFlour;
        double egg = students*10;

        double result = apron*priceOfApron + priceOfEgg * egg + flour * priceOfFlour;
        if (budget >= result) {
            System.out.printf("Items purchased for %.2f$.", result);
        } else {
            result-=budget;
            System.out.printf("%.2f$ more needed.",result);
        }
    }
}
