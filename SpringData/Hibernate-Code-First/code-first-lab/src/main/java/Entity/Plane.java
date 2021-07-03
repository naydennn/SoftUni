package Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{

    private static final String VEHICLE_TYPE = "Plane";

    private Integer passengerCapacity;

    public Plane() {

    }

    public Plane(Integer passengerCapacity) {
        super(VEHICLE_TYPE);
        this.passengerCapacity = passengerCapacity;
    }
}
