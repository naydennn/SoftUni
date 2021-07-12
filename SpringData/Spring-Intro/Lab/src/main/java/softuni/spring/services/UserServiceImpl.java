package softuni.spring.services;

import org.springframework.stereotype.Service;
import softuni.spring.models.User;
import softuni.spring.repositories.AccountRepository;
import softuni.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(User user) {
        if (userRepository.existsById(user.getId())) {
            System.out.println("User already exist");
        }
        userRepository.save(user);

    }
}
