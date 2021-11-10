package bg.softuni.cloudinary.model.binding;

import org.springframework.web.multipart.MultipartFile;

public class PictureBindingModel {

    private String title;
    private MultipartFile multipartFile;

    public String getTitle() {
        return title;
    }

    public PictureBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public PictureBindingModel setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
        return this;
    }
}
