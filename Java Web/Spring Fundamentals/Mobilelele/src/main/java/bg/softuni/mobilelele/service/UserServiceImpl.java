package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> user = userRepository.findByUsername(loginServiceModel.getUsername());

        if (user.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success =  passwordEncoder.matches(loginServiceModel.getRawPassword(),
                    user.get().getPassword());

            if (success) {
                User loggedInUser = user.get();
                currentUser.setUsername(loggedInUser.getUsername());
                currentUser.setFirstName(loggedInUser.getFirstName());
                currentUser.setLastName(loggedInUser.getLastName());
                currentUser.setLoggedIn(true);
            }
            return success;
        }
    }

    public void logout() {
        currentUser.clean();
    }
}
