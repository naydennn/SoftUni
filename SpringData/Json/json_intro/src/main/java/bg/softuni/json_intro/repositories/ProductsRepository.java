package bg.softuni.json_intro.repositories;

import bg.softuni.json_intro.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lower, BigDecimal upper);
}
