package bg.softuni.exap_prep.service;

import bg.softuni.exap_prep.models.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id);
}
