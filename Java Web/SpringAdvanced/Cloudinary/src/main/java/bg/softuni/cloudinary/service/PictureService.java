package bg.softuni.cloudinary.service;

import bg.softuni.cloudinary.model.service.PictureServiceModel;
import bg.softuni.cloudinary.model.view.PictureViewModel;

import java.util.List;

public interface PictureService {

    void addPicture(PictureServiceModel picture);

    void deletePicture(String publicId);

    List<PictureViewModel> findAll();
}
