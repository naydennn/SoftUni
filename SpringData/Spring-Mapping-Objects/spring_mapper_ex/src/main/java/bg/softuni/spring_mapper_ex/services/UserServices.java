package bg.softuni.spring_mapper_ex.services;

import bg.softuni.spring_mapper_ex.models.dtos.LoginUserDto;
import bg.softuni.spring_mapper_ex.models.dtos.UserSeedDto;
import bg.softuni.spring_mapper_ex.models.entities.User;

public interface UserServices {

    void registerUser(UserSeedDto userSeedDto);

    void loginUser(LoginUserDto loginUserDto);

    void logoutUser();

    User getLoggedUser();

}
