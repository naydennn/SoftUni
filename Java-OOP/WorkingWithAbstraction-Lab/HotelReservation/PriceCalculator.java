package HotelReservation;

public class PriceCalculator {
    public static double calculate(double pricePerDay, int days, int multiplier, double discount) {
        return pricePerDay  * days * multiplier * (1- (discount / 100.00));
    }
}
