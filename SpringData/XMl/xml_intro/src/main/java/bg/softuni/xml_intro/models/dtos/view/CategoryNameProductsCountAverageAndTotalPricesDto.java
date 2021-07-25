package bg.softuni.xml_intro.models.dtos.view;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryNameProductsCountAverageAndTotalPricesDto {

    @XmlAttribute
    private String name;
    @XmlElement(name = "product-count")
    private Integer count;
    @XmlElement(name = "average-price")
    private Double avgPrice;
    @XmlElement(name = "total-revenue")
    private BigDecimal totalSum;

    public CategoryNameProductsCountAverageAndTotalPricesDto(String name, Integer count, Double avgPrice, BigDecimal totalSum) {
        this.name = name;
        this.count = count;
        this.avgPrice = avgPrice;
        this.totalSum = totalSum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }
}
