package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.service.UserRegisterServiceModel;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterBindingModel userModel) {

        UserRegisterServiceModel serviceModel = modelMapper
                .map(userModel, UserRegisterServiceModel.class);

        if (!userService.isUserNameFree(serviceModel.getUsername())) {
            return "redirect:/users/register";
        } else {
            userService.registerAndLoginUser(serviceModel);
        }

        return "redirect:/";
    }
}
