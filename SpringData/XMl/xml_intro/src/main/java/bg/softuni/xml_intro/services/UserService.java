package bg.softuni.xml_intro.services;

import bg.softuni.xml_intro.models.dtos.seed.UserSeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.UserWithSoldProductsRootDto;
import bg.softuni.xml_intro.models.entities.User;

public interface UserService {

    void seedData(UserSeedRootDto userSeedRootDto);

    User getRandomUser();

    UserWithSoldProductsRootDto getUserWithSoldProducts();

}
