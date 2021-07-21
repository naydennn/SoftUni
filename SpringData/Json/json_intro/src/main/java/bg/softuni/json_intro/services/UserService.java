package bg.softuni.json_intro.services;

import bg.softuni.json_intro.models.dtos.UserSoldDto;
import bg.softuni.json_intro.models.entities.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {
    void seedUsers() throws IOException;

    User getRandomUser();

    List<UserSoldDto> getUserWithMoreThanOneSoldProducts();
}
