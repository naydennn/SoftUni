package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query("select p.url from Picture p")
    List<String> findAllUrls();
}
