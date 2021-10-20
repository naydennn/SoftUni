package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.Offer;
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

    private OfferSummaryView map(Offer offer) {
        OfferSummaryView offerSummaryView = modelMapper
                .map(offer, OfferSummaryView.class);

        offer.setModel(offer.getModel());
        return offerSummaryView;
    }
}
