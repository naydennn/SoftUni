package Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trcuks")
public class Truck extends Vehicle{

    private static final String VEHICLE_TYPE = "Truck";

    private Double loadCapacity;

    public Truck() {
    }

    public Truck(Double loadCapacity) {
        super(VEHICLE_TYPE);
        this.loadCapacity = loadCapacity;
    }
}
