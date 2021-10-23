package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.enums.EngineTypeEnum;
import bg.softuni.mobilelele.model.enums.TransmissionTypeEnum;

import java.time.LocalDate;

public class OfferDetailsView {

    private String description;
    private EngineTypeEnum engine;
    private LocalDate created;
    private LocalDate modified;
    private String imageUrl;
    private int mileage;
    private String sellerFullName;
    private int price;
    private TransmissionTypeEnum transmission;
    private Integer year;
    private String model;
    private String brand;
    private Long id;

    public OfferDetailsView() {
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public OfferDetailsView setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public OfferDetailsView setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDetailsView setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }
}
