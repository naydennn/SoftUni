package bg.softuni.spring_mapper_ex.repositories;

import bg.softuni.spring_mapper_ex.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        @Query("select u from User u")
        List<User> getAllUsers();

        Optional<User> findByEmailAndPassword(String email, String password);
}
