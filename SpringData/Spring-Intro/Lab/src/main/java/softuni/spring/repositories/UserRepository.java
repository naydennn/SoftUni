package softuni.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
