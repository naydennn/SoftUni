package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAll();
}
