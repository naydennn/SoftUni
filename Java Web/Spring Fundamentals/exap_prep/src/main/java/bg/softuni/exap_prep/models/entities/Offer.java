package bg.softuni.exap_prep.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private String name;
    private Double price;
    private LocalDateTime orderTime;
    private Category category;
    private String description;
    private User employee;

    public Offer() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Offer setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public Double getPrice() {
        return price;
    }

    public Offer setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Offer setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Offer setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToOne
    public User getEmployee() {
        return employee;
    }

    public Offer setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
