package bg.softuni.mobilelele.model.service;

public class UserLoginServiceModel {

    private String username;
    private String rawPassword;

    public UserLoginServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
}
