package bg.softuni.json_ex.repositories;

import bg.softuni.json_ex.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getAllBy();

    List<Car> getAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

}
