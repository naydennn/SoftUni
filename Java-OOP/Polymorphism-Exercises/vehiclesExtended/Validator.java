package vehiclesExtended;

public class Validator {
    public static boolean validNumber (double number) {
        if (number <= 0) {
            System.out.println("Fuel must be a positive number");
            return false;
        }
        return true;
    }
}
