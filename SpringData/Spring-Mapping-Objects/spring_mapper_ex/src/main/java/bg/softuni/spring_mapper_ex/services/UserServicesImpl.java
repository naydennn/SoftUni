package bg.softuni.spring_mapper_ex.services;

import bg.softuni.spring_mapper_ex.models.dtos.LoginUserDto;
import bg.softuni.spring_mapper_ex.models.dtos.UserSeedDto;
import bg.softuni.spring_mapper_ex.models.entities.User;
import bg.softuni.spring_mapper_ex.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private User loginUser;

    public UserServicesImpl(UserRepository userRepository, ModelMapper modelMapper, Validator validator) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public void registerUser(UserSeedDto userSeedDto) {
        if (!userSeedDto.getPassword().equals(userSeedDto.getConfirmPassword())) {
            System.out.println("Incorrect username / password");
            return;
        }

        Set<ConstraintViolation<UserSeedDto>> violations = validator.validate(userSeedDto);

        if (!violations.isEmpty()) {
            printMessages(violations);
            return;
        }

        User user = modelMapper.map(userSeedDto, User.class);
        if (userRepository.getAllUsers().isEmpty()) {
            user.setAdmin(true);
        }
        userRepository.save(user);
        System.out.println(userSeedDto.getFullName() + " was registered");
    }

    private <T> void printMessages(Set<ConstraintViolation<T>> violations) {
        violations.stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
    }

    @Override
    public void loginUser(LoginUserDto loginUserDto) {
        Set<ConstraintViolation<LoginUserDto>> violations = validator.validate(loginUserDto);

        if (!violations.isEmpty()) {
            printMessages(violations);
            return;
        }

        User user = userRepository.findByEmailAndPassword(loginUserDto.getEmail(),
                loginUserDto.getPassword()).orElse(null);
        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        loginUser = user;
        System.out.println("Successfully logged in " + user.getFullName());
    }

    @Override
    public void logoutUser() {
        if (loginUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }
        System.out.println("User " + loginUser.getFullName() + " successfully logged out");
        loginUser = null;
    }

    @Override
    public User getLoggedUser() {
        return loginUser;
    }
}
