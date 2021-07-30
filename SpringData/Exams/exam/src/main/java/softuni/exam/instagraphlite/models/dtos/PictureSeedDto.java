package softuni.exam.instagraphlite.models.dtos;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PictureSeedDto {

    @Expose
    private String path;
    @Expose
    private Double size;

    @NotBlank
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @DecimalMax("60000.0")
    @DecimalMin("500.0")
    @NotNull
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
