package exFiveEntity;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetails{

    private int id;
    private String name;
    private String swift;

    public BankAccount() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
