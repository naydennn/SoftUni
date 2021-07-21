package bg.softuni.json_ex.models.dtos.SeedDtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PartSeedDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private Double quantity;

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
