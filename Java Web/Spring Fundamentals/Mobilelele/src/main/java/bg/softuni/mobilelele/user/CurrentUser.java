package bg.softuni.mobilelele.user;

import bg.softuni.mobilelele.model.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private boolean isLoggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private Set<UserRoleEnum> roles = new HashSet<>();

    public CurrentUser() {
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<UserRoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleEnum> roles) {
        this.roles = roles;
    }

    public void clean() {
        setFirstName(null);
        setLoggedIn(false);
        setLastName(null);
        setUsername(null);
    }

    public CurrentUser addRole(UserRoleEnum role) {
        roles.add(role);
        return this;
    }

    public CurrentUser clearRoles() {
        roles.clear();
        return this;
    }
    public boolean isAdmin() {
        return roles.contains(UserRoleEnum.ADMIN);
    }
}
