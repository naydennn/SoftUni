package bg.softuni.spring_mapper_ex;

import bg.softuni.spring_mapper_ex.models.dtos.AddGameDto;
import bg.softuni.spring_mapper_ex.models.dtos.LoginUserDto;
import bg.softuni.spring_mapper_ex.models.dtos.UserSeedDto;
import bg.softuni.spring_mapper_ex.models.dtos.ViewGameDetails;
import bg.softuni.spring_mapper_ex.services.GameService;
import bg.softuni.spring_mapper_ex.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.math.BigDecimal;

@Component
public class Main implements CommandLineRunner {

    private final BufferedReader reader;
    private final UserServices userServices;
    private final GameService gameService;

    public Main(BufferedReader reader, UserServices userServices, GameService gameService) {
        this.reader = reader;
        this.userServices = userServices;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {


        while (true) {
            System.out.println("Please write commands:");
            String[] commands = reader.readLine().split("\\|");
            switch (commands[0]) {
                case "RegisterUser" -> userServices.registerUser(
                        new UserSeedDto(commands[1], commands[2], commands[3], commands[4])
                );
                case "LoginUser" -> userServices
                        .loginUser(new LoginUserDto(commands[1], commands[2]));
                case "Logout" -> userServices.logoutUser();
                case "AddGame" -> gameService.addGame(new AddGameDto(commands[1], new BigDecimal(commands[2]),
                        Double.parseDouble(commands[3]), commands[4], commands[5], commands[6], commands[7]));
                case "EditGame" -> gameService.editGame(Long.parseLong(commands[1]), new BigDecimal(commands[2].substring(6)),
                        Double.parseDouble(commands[3].substring(5)));
                case "DeleteGame" -> gameService.deleteGame(Long.parseLong(commands[1]));
                case "AllGames" -> printAllGamesTitleAndPrice();
                case "DetailGame" -> printGameDetails(commands[1]);
                case "OwnedGames" -> printGamesTitle();
            }
        }
    }

    private void printGamesTitle() {
        gameService.findGameTitleByUser().forEach(game -> System.out.println(game.getTitle()));
    }

    private void printGameDetails(String command) {
        System.out.println(gameService.getGameByTitle(command).toString());
    }

    private void printAllGamesTitleAndPrice() {
        gameService.getAllGameTitleAndPrice().forEach(game -> System.out.println(game.getTitle() + " " + game.getPrice()));

    }
}
