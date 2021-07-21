package bg.softuni.json_ex.models.dtos.SeedDtos;

import bg.softuni.json_ex.models.entities.Car;
import bg.softuni.json_ex.models.entities.Customer;

public class SaleSeedDto {

    private Car car;
    private Double discountPercentage;
    private Customer customer;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getDiscountPercentage(Double aDouble) {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
