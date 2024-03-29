package bg.softuni.xml_intro.repositories;

import bg.softuni.xml_intro.models.entities.Category;
import bg.softuni.xml_intro.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(BigDecimal lower, BigDecimal upper);
}
