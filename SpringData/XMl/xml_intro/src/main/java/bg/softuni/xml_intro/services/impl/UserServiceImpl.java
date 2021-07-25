package bg.softuni.xml_intro.services.impl;

import bg.softuni.xml_intro.models.dtos.seed.UserSeedRootDto;
import bg.softuni.xml_intro.models.dtos.view.UserWithSoldProduct;
import bg.softuni.xml_intro.models.dtos.view.UserWithSoldProductsRootDto;
import bg.softuni.xml_intro.models.entities.User;
import bg.softuni.xml_intro.repositories.UserRepository;
import bg.softuni.xml_intro.services.UserService;
import bg.softuni.xml_intro.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ValidationUtil validationUtil;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ValidationUtil validationUtil, UserRepository userRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData(UserSeedRootDto userSeedRootDto) {
        if (userRepository.count() == 0) {
            userSeedRootDto.getUsers().stream()
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserWithSoldProductsRootDto getUserWithSoldProducts() {

        UserWithSoldProductsRootDto userWithSoldProductsRootDto = new UserWithSoldProductsRootDto();
        List<User> allUserWithOneSoldProductAndBuyer = userRepository.findAllUserWithOneSoldProductAndBuyer();

         userWithSoldProductsRootDto.setUsers(allUserWithOneSoldProductAndBuyer.stream()
        .map(user -> modelMapper.map(user, UserWithSoldProduct.class))
        .collect(Collectors.toList()));

         return userWithSoldProductsRootDto;
    }
}
