package HotelReservation;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    public final int discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
