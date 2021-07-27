package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PlaneSeedRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlaneServiceImpl implements PlaneService {

    private static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;

    public PlaneServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, PlaneRepository planeRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PlaneSeedRootDto planeSeedRootDto = xmlParser.fromXml(PLANES_FILE_PATH, PlaneSeedRootDto.class);

        planeSeedRootDto.getPlanes().stream()
                .filter(plane -> {
                    boolean isValid = validationUtil.isValid(plane);

                    sb
                            .append(isValid ? String.format("Successfully imported Plane %s",
                                    plane.getRegisterNumber()) : "Invalid plane")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(plane -> modelMapper.map(plane, Plane.class))
                .forEach(planeRepository::save);

        return sb.toString();
    }

    @Override
    public Plane getPlane(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber);
    }
}
