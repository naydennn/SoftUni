package bg.softuni.xml_intro.repositories;

import bg.softuni.xml_intro.models.dtos.view.CategoryNameProductsCountAverageAndTotalPricesDto;
import bg.softuni.xml_intro.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new bg.softuni.xml_intro.models.dtos.view.CategoryNameProductsCountAverageAndTotalPricesDto(" +
            "c.name, c.products.size, AVG(p.price), SUM(p.price)) " +
            "FROM Category AS c " +
            "JOIN c.products AS p " +
            "GROUP BY c.id " +
            "ORDER BY c.products.size DESC")
    List<CategoryNameProductsCountAverageAndTotalPricesDto> findAllAndOrderByProductSize();
}
