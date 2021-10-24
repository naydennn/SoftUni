package bg.softuni.exam.model.binding;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    public String username;
    public String password;

    public UserLoginBindingModel() {
    }

    @Size(min = 3, max = 10)
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Min(3)
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
