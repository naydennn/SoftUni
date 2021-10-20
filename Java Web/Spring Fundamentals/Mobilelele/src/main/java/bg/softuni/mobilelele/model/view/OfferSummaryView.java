package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import bg.softuni.mobilelele.model.enums.TransmissionTypeEnum;

import java.time.LocalDate;

public class OfferSummaryView {

    private Long id;
    private String description;
    private EngineTypeEnum engine;
    private String imageUrl;
    private Integer millage;
    private Double price;
    private TransmissionTypeEnum transmission;
    private LocalDate created;
    private LocalDate modified;
    private String model;

    public OfferSummaryView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypeEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMillage() {
        return millage;
    }

    public void setMillage(Integer millage) {
        this.millage = millage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
