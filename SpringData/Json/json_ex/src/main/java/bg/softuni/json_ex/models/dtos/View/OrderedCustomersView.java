package bg.softuni.json_ex.models.dtos.View;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class OrderedCustomersView {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Date birthDate;
    @Expose
    private Boolean isYoungDriver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
