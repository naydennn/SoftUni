package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureSeedDto;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PictureRepository pictureRepository;
    private final CarService carService;

    public PictureServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, PictureRepository pictureRepository, CarService carService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureRepository = pictureRepository;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        String content = Files.readString(Path.of(PICTURES_FILE_PATH));

        Arrays.stream(gson.fromJson(content, PictureSeedDto[].class))
                .filter(picture -> {
                    boolean isValid = validationUtil.isValid(picture);

                    stringBuilder.append(isValid ?
                            String.format("Successfully import picture - %s",
                                    picture.getName()) :
                            "Invalid picture")
                    .append(System.lineSeparator());

                    return isValid;
                })
                .map(picture -> {
                    Picture mappedPicture = modelMapper.map(picture, Picture.class);
                    mappedPicture.setCar(carService.getCar(picture.getCar()));

                    return mappedPicture;
                })
                .forEach(pictureRepository::save);


        return stringBuilder.toString();
    }
}
