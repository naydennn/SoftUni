package bg.softuni.pathfinder.model.view;


import bg.softuni.pathfinder.model.entity.Role;
import bg.softuni.pathfinder.model.entity.enums.LevelNameEnum;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private Integer age;
    private Set<Role> role;
    private LevelNameEnum level;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Set<Role> getRole() {
        return role;
    }

    public LevelNameEnum getLevel() {
        return level;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserServiceModel setRole(Set<Role> role) {
        this.role = role;
        return this;
    }

    public UserServiceModel setLevel(LevelNameEnum level) {
        this.level = level;
        return this;
    }
}
