package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLER_FILE_NAME = "src/main/resources/files/xml/sellers.xml";

    private final ModelMapper modelMapper;
    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public SellerServiceImpl(ModelMapper modelMapper, SellerRepository sellerRepository, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_NAME));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        SellerSeedRootDto sellerSeedRootDto = xmlParser.fromXml(SELLER_FILE_NAME, SellerSeedRootDto.class);

        sellerSeedRootDto.getSellers().stream()
                .filter(seller -> {
                    boolean isValid = validationUtil.isValid(seller);

                    sb.append(isValid ? String.format("Successfully import seller %s- %s",
                            seller.getLastName(), seller.getEmail()) :
                            "Invalid seller")
                    .append(System.lineSeparator());
                    return isValid;
                })
                .map(seller -> modelMapper.map(seller, Seller.class))
                .forEach(sellerRepository::save);


        return sb.toString();
    }

    @Override
    public Seller getSeller(Long id) {
        return sellerRepository.getOne(id);
    }
}
