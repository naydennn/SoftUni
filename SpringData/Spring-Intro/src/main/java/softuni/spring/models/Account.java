package softuni.spring.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Account extends BaseEntity {

    private BigDecimal balance;
    @ManyToOne
    private User user;

    @Column
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
