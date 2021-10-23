package bg.softuni.pathfinder.model.view;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Picture;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.entity.enums.LevelNameEnum;

import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String gpxCoordinates;
    private String videoUrl;
    private String description;
    private String name;
    private LevelNameEnum level;
    private User author;
    private Set<Picture> pictures;
    private Set<Category> categories;

    public RouteServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LevelNameEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelNameEnum level) {
        this.level = level;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
