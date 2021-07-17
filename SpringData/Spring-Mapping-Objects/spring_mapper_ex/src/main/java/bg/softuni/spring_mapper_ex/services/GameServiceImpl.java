package bg.softuni.spring_mapper_ex.services;

import bg.softuni.spring_mapper_ex.models.dtos.AddGameDto;
import bg.softuni.spring_mapper_ex.models.dtos.ViewGameDetails;
import bg.softuni.spring_mapper_ex.models.dtos.ViewGameTitleAndPriceDto;
import bg.softuni.spring_mapper_ex.models.dtos.ViewOwnedGameDto;
import bg.softuni.spring_mapper_ex.models.entities.Game;
import bg.softuni.spring_mapper_ex.models.entities.User;
import bg.softuni.spring_mapper_ex.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final GameRepository gameRepository;
    private final UserServices userServices;

    public GameServiceImpl(ModelMapper modelMapper, Validator validator, GameRepository gameRepository, UserServices userServices) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.gameRepository = gameRepository;
        this.userServices = userServices;
    }

    @Override
    public void addGame(AddGameDto addGameDto) {
        if (getUser()) return;

        Set<ConstraintViolation<AddGameDto>> violations = validator.validate(addGameDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(addGameDto, Game.class);
        game.setReleaseDate(LocalDate.parse(addGameDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        gameRepository.save(game);
        System.out.println("Added " + game.getTitle());
    }

    private boolean getUser() {
        User loggedUser = userServices.getLoggedUser();

        if (loggedUser == null || !loggedUser.getAdmin()) {
            System.out.println("No logged user or user is not admin.");
            return true;
        }
        return false;
    }

    @Override
    public void editGame(Long id, BigDecimal price, Double size) {
        if (getUser()) return;

        Game game = gameRepository.findById(id).orElse(null);
        if (game == null) {
            System.out.println("No game with that id");
        }

        game.setPrice(price);
        game.setSize((int) Math.round(size));

        gameRepository.save(game);
        System.out.println("Edited " + game.getTitle());
    }

    @Override
    public void deleteGame(long id) {

        if (getUser()) return;

        Game game = gameRepository.findById(id).orElse(null);
        if (game == null) {
            System.out.println("No founded game with this id");
            return;
        }
        gameRepository.deleteById(id);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public List<ViewGameTitleAndPriceDto> getAllGameTitleAndPrice() {
        List<Game> games = gameRepository.getAllBy();

        List<ViewGameTitleAndPriceDto> viewAllGames = new ArrayList<>();
        for (Game game : games) {
            viewAllGames.add(modelMapper.map(game, ViewGameTitleAndPriceDto.class));
        }

        return viewAllGames;
    }

    @Override
    public ViewGameDetails getGameByTitle(String title) {


        return modelMapper.map(gameRepository.findByTitle(title), ViewGameDetails.class);
    }

    @Override
    public List<ViewOwnedGameDto> findGameTitleByUser() {
        List<ViewOwnedGameDto> games = new ArrayList<>();

        List<Game> allByUsers = gameRepository.findAllByUser(Set.of(userServices.getLoggedUser()));
        for (Game game : allByUsers) {
            games.add(modelMapper.map(game, ViewOwnedGameDto.class));
        }

        return games;
    }
}
