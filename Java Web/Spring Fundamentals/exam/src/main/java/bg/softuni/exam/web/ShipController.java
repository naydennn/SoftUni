package bg.softuni.exam.web;

import bg.softuni.exam.model.binding.ShipAddBindingModel;
import bg.softuni.exam.model.service.ShipServiceModel;
import bg.softuni.exam.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ModelMapper modelMapper;
    private final ShipService shipService;

    public ShipController(ModelMapper modelMapper, ShipService shipService) {
        this.modelMapper = modelMapper;
        this.shipService = shipService;
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShip(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/home";
    }

    @PostMapping("/fire")
    public String fire(@RequestParam(value = "attackerName") String attackerName,
                       @RequestParam(value = "defenderName") String defenderName) {

        shipService.attack(attackerName, defenderName);

        return "redirect:/home";
    }
}
