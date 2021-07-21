package bg.softuni.json_ex.repositories;

import bg.softuni.json_ex.models.dtos.View.SupplierView;
import bg.softuni.json_ex.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
