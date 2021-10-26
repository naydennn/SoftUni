package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.entity.Ship;
import bg.softuni.exam.model.service.ShipServiceModel;
import bg.softuni.exam.model.view.ShipViewModel;
import bg.softuni.exam.repository.ShipRepository;
import bg.softuni.exam.sec.CurrentUser;
import bg.softuni.exam.service.CategoryService;
import bg.softuni.exam.service.ShipService;
import bg.softuni.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ModelMapper modelMapper;
    private final ShipRepository shipRepository;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;
    private final UserService userService;

    public ShipServiceImpl(ModelMapper modelMapper, ShipRepository shipRepository, CurrentUser currentUser, CategoryService categoryService, UserService userService) {
        this.modelMapper = modelMapper;
        this.shipRepository = shipRepository;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);

        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAllShip() {

        return shipRepository.findAll().stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAllShipById(Long id) {
        return userService.findById(id).getShips().stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAllShipWithoutLoggedInUser(Long id) {
        return shipRepository.findAll().stream()
                .filter(ship -> !Objects.equals(ship.getUser().getId(), id))
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void attack(String attackerName, String defenderName) {
        Ship attackerShip = shipRepository.findByName(attackerName).get();
        Ship defenderShip = shipRepository.findByName(defenderName).get();

        if (defenderShip.getHealth() - attackerShip.getPower() <= 0) {
            shipRepository.delete(defenderShip);
        } else {
            defenderShip.setHealth(attackerShip.getPower() - defenderShip.getHealth());
            shipRepository.save(defenderShip);
        }
    }
}
