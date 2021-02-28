package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be a empty.");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (getMoney() >= product.getCost()) {
            setMoney(this.money - product.getCost());
            this.products.add(product);
            System.out.println(getName() + " bought " + product.getName());
        } else {
            System.out.println(getName() + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getName()).append(" - ");
        if (this.products.isEmpty()) {
            result.append("Nothing bought");
            return result.toString();
        }
        for (Product product : products) {
            result.append(product.getName()).append(", ");
        }
        return result.substring(0, result.lastIndexOf(","));
    }
}
