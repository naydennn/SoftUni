package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferSeedRootDto;
import softuni.exam.models.entities.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;
    private final CarService carService;
    private final SellerService sellerService;

    public OfferServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, OfferRepository offerRepository, ValidationUtil validationUtil, CarService carService, SellerService sellerService) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferSeedRootDto offerSeedRootDto = xmlParser.fromXml(OFFERS_FILE_PATH, OfferSeedRootDto.class);

        offerSeedRootDto.getOffers().stream()
                .filter(offer -> {
                    boolean isValid = validationUtil.isValid(offer);

                    sb.append(isValid ? String.format("Successfully import offer %s - %s",
                            offer.getAddedOn(), offer.getHasGoldenStatus()) :
                            "Invalid offer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(offer -> {
                    Offer mappedOffer = modelMapper.map(offer, Offer.class);

                    mappedOffer.setAddedOn(LocalDateTime.parse(offer.getAddedOn(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                    mappedOffer.setCar(carService.getCar(offer.getCar().getId()));
                    mappedOffer.setSeller(sellerService.getSeller(offer.getSeller().getId()));

                    return mappedOffer;
                })
                .forEach(offerRepository::save);

        return sb.toString();
    }
}
