package bg.softuni.spring_mapper_ex.models.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class ViewGameTitleAndPriceDto {

    private String title;
    private BigDecimal price;

    public ViewGameTitleAndPriceDto() {
    }

    public ViewGameTitleAndPriceDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Pattern(regexp = "[A-Z][a-z]{3,100}",
            message = "Please write valid title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0", message = "Please write positive price.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
