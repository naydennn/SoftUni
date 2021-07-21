package bg.softuni.json_ex.repositories;

import bg.softuni.json_ex.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getAllBy();

    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate")
    List<Customer> getAllByBirthdate();
}
