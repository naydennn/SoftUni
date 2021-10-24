package bg.softuni.exam.web;

import bg.softuni.exam.sec.CurrentUser;
import bg.softuni.exam.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }


    @GetMapping("/home")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("ships", shipService.findAllShip());
        model.addAttribute("loggedUserShips", shipService.findAllShipById(currentUser.getId()));
        model.addAttribute("anotherUsersShips", shipService.findAllShipWithoutLoggedInUser(currentUser.getId()));

        return "home";
    }


}
