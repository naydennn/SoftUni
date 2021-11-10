package bg.softuni.cloudinary.model.service;

public class PictureServiceModel {

    private Long id;
    private String url;
    private String title;
    private String publicId;

    public PictureServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public PictureServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureServiceModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PictureServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureServiceModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
