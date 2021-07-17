package bg.softuni.spring_mapper_ex.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class LoginUserDto {

    private String email;
    private String password;

    public LoginUserDto() {
    }

    public LoginUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Email(message = "Incorrect email address")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "[A-Za-z\\d]{6,}",
            message = "Password must contain 6 characters with upper case, lower case, digit at least one and no white space.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
