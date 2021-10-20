package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.model.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;

        this.userRoleRepository = userRoleRepository;
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
                login(loggedInUser);
                loggedInUser.getRoles().forEach(r -> currentUser.addRole(r.getRole()));
            }
            return success;
        }
    }

    public void logout() {
        currentUser.clean();
        currentUser.clearRoles();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {

        UserRole userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        User userToRegister = new User();

        userToRegister.setFirstName(userRegisterServiceModel.getFirstName());
        userToRegister.setLastName(userRegisterServiceModel.getLastName());
        userToRegister.setUsername(userRegisterServiceModel.getUsername());
        userToRegister.setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()));
        userToRegister.setActive(true);
        userToRegister.setRoles(Set.of(userRole));

        userRepository.save(userToRegister);

        login(userToRegister);

    }

    @Override
    public boolean isUserNameFree(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }

    private void login(User user) {
        currentUser.setLoggedIn(true);
        currentUser.setUsername(user.getUsername());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
    }
}
