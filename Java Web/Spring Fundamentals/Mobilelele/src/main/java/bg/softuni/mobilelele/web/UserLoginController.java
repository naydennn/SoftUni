package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginBindingModel userLoginBindingModel){

        UserLoginServiceModel userLogin = new UserLoginServiceModel();
        userLogin.setUsername(userLoginBindingModel.getUsername());
        userLogin.setRawPassword(userLoginBindingModel.getPassword());

        boolean loginSuccessful = userService.login(userLogin);

        if(loginSuccessful) {
            return "redirect:/";
        }
        return "redirect:/users/login";
    }

}
