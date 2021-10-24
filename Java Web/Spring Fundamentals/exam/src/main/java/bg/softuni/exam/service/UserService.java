package bg.softuni.exam.service;

import bg.softuni.exam.model.entity.User;
import bg.softuni.exam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id);

    User findById(Long id);
}
