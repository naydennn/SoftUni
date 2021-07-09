package softuni.spring;

import org.springframework.boot.CommandLineRunner;
import softuni.spring.models.User;
import softuni.spring.services.UserService;

import java.util.Scanner;

public class ConsoleRunner implements CommandLineRunner {

    private final Scanner sc = new Scanner(System.in);
    private final UserService userService;

    private User user;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
        this.user = null;
    }

    @Override
    public void run(String... args) throws Exception {

        String username = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        user.setUsername(username);
        user.setAge(age);

        userService.registerUser(user);
    }
}
