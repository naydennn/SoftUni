package exFiveEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

    private int id;
    private int number;
    private User user;

    @Column
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
