package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.view.OfferDetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {

    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id);

    void deleteOffer(Long id);
}
