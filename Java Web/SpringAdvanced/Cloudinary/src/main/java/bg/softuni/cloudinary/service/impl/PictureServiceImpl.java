package bg.softuni.cloudinary.service.impl;

import bg.softuni.cloudinary.model.entity.PictureEntity;
import bg.softuni.cloudinary.model.service.PictureServiceModel;
import bg.softuni.cloudinary.model.view.PictureViewModel;
import bg.softuni.cloudinary.repository.PictureRepository;
import bg.softuni.cloudinary.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPicture(PictureServiceModel pictureServiceModel) {

        PictureEntity map = modelMapper.map(pictureServiceModel, PictureEntity.class);
        pictureRepository.save(map);
    }

    @Override
    public void deletePicture(String publicId) {
        pictureRepository.deleteAllByPublicId(publicId);
    }

    @Override
    public List<PictureViewModel> findAll() {
        return pictureRepository.findAll().stream().
                map(pictureEntity -> modelMapper.map(pictureEntity, PictureViewModel.class)).
                collect(Collectors.toList());
    }
}
