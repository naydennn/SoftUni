package bg.softuni.json_intro.repositories;

import bg.softuni.json_intro.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    @Query("select u from User u " +
            "where (select count(p) from Product p where p.seller.id = u.id) > 0 order by u.lastName, u.firstName")
    List<User> findAllBySoldProductsIsNotNull();
}
