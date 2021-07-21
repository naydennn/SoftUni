package bg.softuni.json_intro.services.impl;

import bg.softuni.json_intro.models.dtos.UserSeedDto;
import bg.softuni.json_intro.models.dtos.UserSoldDto;
import bg.softuni.json_intro.models.entities.User;
import bg.softuni.json_intro.repositories.UsersRepository;
import bg.softuni.json_intro.services.UserService;
import bg.softuni.json_intro.utils.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static bg.softuni.json_intro.constraints.GlobalConstraint.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "users.json";

    private final ValidatorUtil validator;
    private final Gson gson;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ValidatorUtil validator, Gson gson, UsersRepository usersRepository, ModelMapper modelMapper) {
        this.validator = validator;
        this.gson = gson;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers() throws IOException {

        if (usersRepository.count() == 0) {
            String fileContent = Files
                    .readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_PATH));

            Arrays.stream(gson.fromJson(fileContent, UserSeedDto[].class))
                    .filter(validator::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(usersRepository::save);
        }
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, usersRepository.count() + 1);
        return usersRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserSoldDto> getUserWithMoreThanOneSoldProducts() {
        return usersRepository.findAllBySoldProductsIsNotNull()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());

    }
}
