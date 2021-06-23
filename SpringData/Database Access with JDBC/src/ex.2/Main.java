import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write user name to found:");

        String userName = sc.nextLine();
        Connection cnc = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo",  "root", "787898");

        PreparedStatement preparedStatement = cnc.prepareStatement("SELECT u.user_name, u.first_name, u.last_name, COUNT(g.id) AS game_count FROM users AS u, users_games AS g WHERE u.user_name = ? AND u.id = g.user_id GROUP BY g.user_id");
        preparedStatement.setString(1, userName);

        ResultSet resultSet = preparedStatement.executeQuery();

        boolean hasNext = false;

        while(resultSet.next()) {
            hasNext = true;
            System.out.println("User:" + resultSet.getString("user_name"));
            System.out.println(resultSet.getString("first_name") + " " +
                    resultSet.getString("last_name") + " has played" + " " +
                    resultSet.getString("game_count") + " games");
        }
        if (!hasNext) {
            System.out.println("No users with that name.");
        }

    }
}
