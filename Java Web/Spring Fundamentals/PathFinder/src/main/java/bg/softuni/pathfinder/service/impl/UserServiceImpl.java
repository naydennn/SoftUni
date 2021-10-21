package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.entity.enums.LevelNameEnum;
import bg.softuni.pathfinder.model.view.UserServiceModel;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel serviceModel) {
        User user = modelMapper.map(serviceModel, User.class);

        user.setLevel(LevelNameEnum.BEGINNER);

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
            currentUser.setId(id);
            currentUser.setUsername(username);
    }

    @Override
    public void logout() {
        currentUser.setUsername(null);
        currentUser.setId(null);
    }
}
