package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.UserRoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    private UserRoleEnum name;

    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return name;
    }

    public void setRole(UserRoleEnum name) {
        this.name = name;
    }
}
