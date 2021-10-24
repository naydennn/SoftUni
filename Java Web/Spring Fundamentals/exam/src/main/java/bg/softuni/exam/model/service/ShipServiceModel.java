package bg.softuni.exam.model.service;

import bg.softuni.exam.model.entity.User;
import bg.softuni.exam.model.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipServiceModel {

    private Long id;
    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNameEnum category;
    private User user;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipServiceModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShipServiceModel setUser(User user) {
        this.user = user;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
