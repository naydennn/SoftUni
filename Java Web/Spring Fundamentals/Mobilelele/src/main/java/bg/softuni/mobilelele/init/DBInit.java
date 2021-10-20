package bg.softuni.mobilelele.init;


import bg.softuni.mobilelele.model.entity.*;
import bg.softuni.mobilelele.model.enums.CategoryNameEnum;
import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import bg.softuni.mobilelele.model.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.model.enums.UserRoleEnum;
import bg.softuni.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private OfferRepository offerRepository;
    private PasswordEncoder passwordEncoder;
    private ModelRepository modelRepository;
    private BrandRepository brandRepository;

    public DBInit(UserRepository userRepository, UserRoleRepository userRoleRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, ModelRepository modelRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRoleRepository.count() == 0) {
            initUserRole();
        }
        if (userRepository.count() == 0) {
            initUsers();
        }
        if (brandRepository.count() == 0) {
            initializeBrand();
        }

        if (offerRepository.count() == 0) {
            initializeOffers();
        }

        if (modelRepository.count() == 0) {
            initializeModels();
        }

    }

    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }

    public void initializeModels() {

        Brand ford = brandRepository.findByName("Ford")
                .orElseThrow(IllegalArgumentException::new);

        Model fiesta = new Model();
        fiesta.setName("Fiesta");
        fiesta.setCategory(CategoryNameEnum.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(ford);

        Model escort = new Model();
        escort.setName("Escort");
        escort.setCategory(CategoryNameEnum.CAR);
        escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg");
        escort.setStartYear(1967);
        escort.setEndYear(2004);
        escort.setBrand(ford);
        ;

        modelRepository.saveAll(List.of(fiesta, escort));
    }

    public void initializeOffers() {

        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            offer1.setModel(modelRepository.findById(1L).orElse(null));
            offer1.setEngine(EngineTypeEnum.GASOLINE);
            offer1.setTransmission(TransmissionTypeEnum.MANUAL);
            offer1.setMileage(22500);
            offer1.setPrice(14300.0);
            offer1.setYear(2019);
            offer1.setDescription("Used, but well services and in good condition.");
            offer1.setSeller(userRepository.findByUsername("pesho")
                    .orElse(null)); // or currentUser.getUserName()
            offer1.setImageUrl(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXp1KBpDKgYs6VqndkBpX8twjPOZbHV86yg&usqp=CAU");

            Offer offer2 = new Offer();
            offer2.setModel(modelRepository.findById(1L).orElse(null));
            offer2.setEngine(EngineTypeEnum.DIESEL);
            offer2.setTransmission(TransmissionTypeEnum.AUTOMATIC);
            offer2.setMileage(209000);
            offer2.setPrice(5500.0);
            offer2.setYear(2000);
            offer2.setDescription("After full maintenance, insurance, new tires...");
            offer2.setSeller(userRepository.findByUsername("admin")
                    .orElse(null)); // or currentUser.getUserName()
            offer2.setImageUrl(
                    "https://www.picclickimg.com/d/l400/pict/283362908243_/FORD-ESCORT-MK5-16L-DOHC-16v-ZETEC.jpg");

            offerRepository.saveAll(List.of(offer1, offer2));
        }
    }

    private void initUsers() {
        User admin = new User();
        UserRole adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
        UserRole userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        admin.setActive(true);
        admin.setUsername("admin");
        admin.setFirstName("Admin");
        admin.setLastName("Adminov");
        admin.setPassword(passwordEncoder.encode("test"));
        admin.setRoles(Set.of(adminRole, userRole));
        userRepository.save(admin);

        User pesho = new User();
        pesho.setActive(true);
        pesho.setUsername("pesho");
        pesho.setFirstName("Pesho");
        pesho.setLastName("Peshov");
        pesho.setPassword(passwordEncoder.encode("1234"));
        pesho.setRoles(Set.of(userRole));
        userRepository.save(pesho);
    }

    private void initUserRole() {

        UserRole adminRole = new UserRole();
        adminRole.setRole(UserRoleEnum.ADMIN);

        UserRole userRole = new UserRole();
        userRole.setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));
    }
}
