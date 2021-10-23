package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.view.OfferDetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id) {
        return offerRepository.findById(id)
                .map(this::offerDetailsView)
                .orElse(null);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    private OfferDetailsView offerDetailsView(Offer offer) {
        OfferDetailsView offerDetailsView = modelMapper.map(offer, OfferDetailsView.class);

        offerDetailsView.setBrand(offer.getModel().getBrand().getName());
        offerDetailsView.setModel(offer.getModel().getName());
        offerDetailsView.setSellerFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());

        return offerDetailsView;
    }

    private OfferSummaryView map(Offer offer) {
        OfferSummaryView offerSummaryView = modelMapper
                .map(offer, OfferSummaryView.class);

        offerSummaryView.setModel(offer.getModel().getName());
        offerSummaryView.setBrand(offer.getModel().getBrand().getName());
        return offerSummaryView;
    }
}
