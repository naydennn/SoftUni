package bg.softuni.exam.service;


import bg.softuni.exam.model.service.ShipServiceModel;
import bg.softuni.exam.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShip();

    List<ShipViewModel> findAllShipById(Long id);

    List<ShipViewModel> findAllShipWithoutLoggedInUser(Long id);
}
