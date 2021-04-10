package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        switch (aquariumType) {
            case "FreshwaterAquarium":
                this.aquariums.add(new FreshwaterAquarium(aquariumName));
                break;
            case "SaltwaterAquarium":
                this.aquariums.add(new SaltwaterAquarium(aquariumName));
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        switch (type) {
            case "Ornament":
                this.decorations.add(new Ornament());
                break;
            case "Plant":
                this.decorations.add(new Plant());
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
                decorations.remove(decoration);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();

        if (fishType.equals("FreshwaterFish")) {
            if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
                return WATER_NOT_SUITABLE;
            }
            aquarium.addFish(new FreshwaterFish(fishName, fishSpecies, price));
        } else if (fishType.equals("SaltwaterFish")) {
            if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
                return WATER_NOT_SUITABLE;
            }

            aquarium.addFish(new SaltwaterFish(fishName, fishSpecies, price));

        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();
        double sum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        sum += aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder result = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            result.append(aquarium.getInfo());
        }
        return result.toString();
    }
}
