package bg.softuni.xml_intro.repositories;

import bg.softuni.xml_intro.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where " +
            "(select count(p) from Product p where p.seller.id = u.id and p.buyer is not null) > 0 " +
            "ORDER BY u.firstName, u.lastName")
    List<User> findAllUserWithOneSoldProductAndBuyer();
}
