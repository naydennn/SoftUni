package bg.softuni.json_ex.services;

import bg.softuni.json_ex.models.dtos.View.OrderedCustomersView;
import bg.softuni.json_ex.models.entities.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void seedData() throws IOException;

    List<Customer> getAllCustomers();

    List<OrderedCustomersView> getAllCustomersOrderedByBirthDate();
}
