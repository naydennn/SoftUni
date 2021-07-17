package bg.softuni.spring_mapper_ex.models.dtos;

import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserSeedDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserSeedDto() {
    }

    public UserSeedDto(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    @Email(message = "Incorrect email.")
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
