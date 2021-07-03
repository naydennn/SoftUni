package Entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{

    private static final String VEHICLE_TYPE = "Car";

    private Integer seats;

    public Car(Integer seats) {
        super(VEHICLE_TYPE);
        this.seats = seats;
    }

    public Car() {

    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

}
