package bg.softuni.json_ex.services;

import bg.softuni.json_ex.models.entities.Part;

import java.io.IOException;
import java.util.List;

public interface PartServices {
    void seedData() throws IOException;

    List<Part> getRandomParts();
}
