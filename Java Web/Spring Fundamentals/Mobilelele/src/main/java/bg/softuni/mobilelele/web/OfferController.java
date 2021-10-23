package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers/")
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("{id}/details")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("offer", offerService.findById(id));
        return "details";
    }

    @DeleteMapping("{id}")
    public String deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);

        return "redirect:all";
    }
}
