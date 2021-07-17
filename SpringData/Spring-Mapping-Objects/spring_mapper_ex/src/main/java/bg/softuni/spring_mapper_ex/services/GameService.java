package bg.softuni.spring_mapper_ex.services;

import bg.softuni.spring_mapper_ex.models.dtos.AddGameDto;
import bg.softuni.spring_mapper_ex.models.dtos.ViewGameDetails;
import bg.softuni.spring_mapper_ex.models.dtos.ViewGameTitleAndPriceDto;
import bg.softuni.spring_mapper_ex.models.dtos.ViewOwnedGameDto;
import bg.softuni.spring_mapper_ex.models.entities.User;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(AddGameDto addGameDto);

    void editGame(Long id, BigDecimal price, Double size);

    void deleteGame(long id);

    List<ViewGameTitleAndPriceDto> getAllGameTitleAndPrice();

    ViewGameDetails getGameByTitle(String command);

    List<ViewOwnedGameDto> findGameTitleByUser();
}
