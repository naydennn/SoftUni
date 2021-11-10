package bg.softuni.cloudinary.web;

import bg.softuni.cloudinary.model.binding.PictureBindingModel;
import bg.softuni.cloudinary.model.service.PictureServiceModel;
import bg.softuni.cloudinary.model.view.PictureViewModel;
import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import bg.softuni.cloudinary.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pictures")
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;

    public PictureController(CloudinaryService cloudinaryService, PictureService pictureService) {
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
    }

    @GetMapping("/all")
    public String getAllPictures(Model model) {

        List<PictureViewModel> allPictures = pictureService.findAll();

        model.addAttribute("pictures", allPictures);
        return "all";
    }

    @GetMapping("/add")
    public String addPicture() {
        return "add";
    }

    @PostMapping("/add")
    public String addPicture(@RequestParam("picture") MultipartFile picture,
                             @RequestParam("title") String title) throws IOException {

        CloudinaryImage uploadedImage = cloudinaryService.upload(picture);

        pictureService.addPicture(new PictureServiceModel().setTitle(title).
                setPublicId(uploadedImage.getPublicId()).
                setUrl(uploadedImage.getUrl()));

        return "redirect:/pictures/all";
    }

    @Transactional
    @DeleteMapping("/delete")
    public String delete(@RequestParam("public_id") String publicId) {

        if (cloudinaryService.delete(publicId)) {
            pictureService.deletePicture(publicId);
        }

        return "redirect:/pictures/all";
    }
}
