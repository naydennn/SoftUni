package bg.softuni.spring_mapper_ex.repositories;

import bg.softuni.spring_mapper_ex.models.entities.Game;
import bg.softuni.spring_mapper_ex.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findById(Long id);

    void deleteById(Long id);

    List<Game> getAllBy();

    Game findByTitle(String title);

    List<Game> findAllByUser(Set<User> users);
}
