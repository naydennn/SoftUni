package bg.softuni.json_ex.models.dtos.View;

import bg.softuni.json_ex.models.entities.Part;
import com.google.gson.annotations.Expose;

import java.util.List;

public class CarWithPartsDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;
    @Expose
    private List<PartView> parts;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartView> getParts() {
        return parts;
    }

    public void setParts(List<PartView> parts) {
        this.parts = parts;
    }
}
