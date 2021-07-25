package bg.softuni.xml_intro.models.dtos.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewRootDto {

    @XmlElement(name = "product")
    List<ProductWithRangeViewDto> products;

    public List<ProductWithRangeViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithRangeViewDto> products) {
        this.products = products;
    }
}
