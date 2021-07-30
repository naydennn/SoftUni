package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final PictureRepository pictureRepository;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(ModelMapper modelMapper, Gson gson, PictureRepository pictureRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.pictureRepository = pictureRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(picture -> {
                    boolean isValid = validationUtil.isValid(picture);

                    sb.append(isValid ? String.format("Successfully imported Picture, with size %.2f",
                            picture.getSize()) : "Invalid Picture")
                    .append(System.lineSeparator());

                    return isValid;
                })
                .map(picture -> modelMapper.map(picture, Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }

    @Override
    public String exportPictures() {

        StringBuilder sb = new StringBuilder();

        pictureRepository.findAllBySizeGreaterThanOrderBySize(30000.00)
                .forEach(picture -> sb.append(String.format("%.2f - %s%n",
                        picture.getSize(), picture.getPath())));
        return sb.toString();
    }

    @Override
    public Picture getPicture(String path) {
        return pictureRepository.findByPath(path);
    }
}
