package bg.softuni.exam.repository;

import bg.softuni.exam.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findAll();

    Optional<Ship> findByName(String name);
}
