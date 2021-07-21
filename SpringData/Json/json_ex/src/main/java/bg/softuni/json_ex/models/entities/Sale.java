package bg.softuni.json_ex.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{

    private Customer customer;
    private Double discountPercentage;
    private Car car;

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @OneToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
