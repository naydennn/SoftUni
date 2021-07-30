package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.UserSeedDto;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    public UserServiceImpl(ModelMapper modelMapper, Gson gson, UserRepository userRepository, ValidationUtil validationUtil, PictureService pictureService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), UserSeedDto[].class))
                .filter(user -> {
                    boolean isValid = validationUtil.isValid(user);
                    if (isValid) {
                        isValid = pictureService.getPicture(user.getProfilePicture()) != null;
                    }

                    sb.append(isValid ? String.format("Successfully imported User: %s",
                            user.getUsername()) : "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(user -> {
                    User mappedUser = modelMapper.map(user, User.class);

                    mappedUser.setProfilePicture(pictureService.getPicture(user.getProfilePicture()));

                    return mappedUser;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {

        StringBuilder sb = new StringBuilder();

        userRepository.findAllUserOrderByTheirPostDescThenById()
                .forEach(user -> {
                    sb.append(String.format("\"User: %s\n" +
                            "Post count: %d\n", user.getUsername(), user.getPosts().size()));
                            user.getPosts().forEach(post ->sb.append(String.format("==Post Details:\n" +
                                    "----Caption: %s\n" +
                                    "----Picture Size: %.2f%n", post.getCaption(), post.getPicture().getSize())));

                });

        return sb.toString();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
