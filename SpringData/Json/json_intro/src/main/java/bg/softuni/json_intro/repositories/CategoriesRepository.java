package bg.softuni.json_intro.repositories;

import bg.softuni.json_intro.models.dtos.CategoriesByProductDto;
import bg.softuni.json_intro.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c.name, c.products.size, AVG(p.price), SUM(p.price)" +
            "FROM Category AS c " +
            "JOIN c.products AS p " +
            "GROUP BY c.id " +
            "ORDER BY c.products.size DESC")
    List<Object[]> getAllCategoriesOrderByNumberOfProducts();
}
