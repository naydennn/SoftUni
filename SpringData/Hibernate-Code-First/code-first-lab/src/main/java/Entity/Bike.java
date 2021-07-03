package Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    private static final String VEHICLE_TYPE = "Bike";

    public Bike() {
        super(VEHICLE_TYPE);
    }
}
