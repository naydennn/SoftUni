package bg.softuni.xml_intro.models.dtos.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsRootDto {

    @XmlElement(name = "user")
    List<UserWithSoldProduct> users;

    public List<UserWithSoldProduct> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProduct> users) {
        this.users = users;
    }
}
