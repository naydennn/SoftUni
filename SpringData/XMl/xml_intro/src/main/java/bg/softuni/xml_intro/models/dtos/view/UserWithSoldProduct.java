package bg.softuni.xml_intro.models.dtos.view;

import bg.softuni.xml_intro.models.entities.Product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProduct {

    @XmlAttribute
    private String firstName;
    @XmlAttribute
    private String lastName;
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ProductWithBuyerDto> soldProducts;

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

    public List<ProductWithBuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductWithBuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
