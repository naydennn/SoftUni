package bg.softuni.spring_mapper_ex.models.dtos;

public class ViewOwnedGameDto {

    private String title;

    public ViewOwnedGameDto() {
    }

    public ViewOwnedGameDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
