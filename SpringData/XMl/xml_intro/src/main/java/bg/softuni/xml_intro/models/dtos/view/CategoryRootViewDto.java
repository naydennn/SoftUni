package bg.softuni.xml_intro.models.dtos.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootViewDto {

    @XmlElement(name = "category")
    private List<CategoryNameProductsCountAverageAndTotalPricesDto> categories;

    public List<CategoryNameProductsCountAverageAndTotalPricesDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryNameProductsCountAverageAndTotalPricesDto> categories) {
        this.categories = categories;
    }
}
