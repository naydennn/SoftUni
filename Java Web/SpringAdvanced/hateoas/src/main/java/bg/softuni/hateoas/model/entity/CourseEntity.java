package bg.softuni.hateoas.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity {

    private String name;
    private Double price;
    private List<OrderEntity> orders;

    public CourseEntity() {
    }

    public String getName() {
        return name;
    }

    public CourseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CourseEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    @OneToMany(mappedBy = "courses")
    public List<OrderEntity> getOrders() {
        return orders;
    }

    public CourseEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
