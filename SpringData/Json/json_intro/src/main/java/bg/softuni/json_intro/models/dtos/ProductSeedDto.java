package bg.softuni.json_intro.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductSeedDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
