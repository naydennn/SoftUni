import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;
    private static String query;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        while (true) {
            System.out.print("Choose an exercise or press 0 to exit --->");
            int numOfExercises = Integer.parseInt(reader.readLine());

            switch (numOfExercises) {
                case 2 -> exTwo();
                case 3 -> exThree();
                case 4 -> exFour();
                case 5 -> exFive();
                case 6 -> exSix();
                case 7 -> exSeven();
                case 8 -> exEight();
                case 9 -> exNine();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Please choose one of exercises: 2, 3, 4, 5, 6, 7, 8, 9 or 0 to exit");
            }
        }
    }

    private static void exFour() throws IOException, SQLException {
        System.out.println("Write a minion... Minion: ");
        String[] minionInfo = reader.readLine().split(" ");
        System.out.println("Write a villain... Villain: ");
        String villainInfo = reader.readLine();

        if (findEntityByFieldQuery(minionInfo[2], "SELECT name FROM towns WHERE name = ?", "name") == null) {
            query = "INSERT INTO towns (name) VALUES(?)";
            insertIntoDatabase(query, minionInfo[2]);
            System.out.printf("Town %s was added to databases%n", minionInfo[2]);
        }
        if (findEntityByFieldQuery(villainInfo, "SELECT name FROM villains WHERE name = ?", "name") == null) {
            query = "INSERT INTO villains (name, evilness_factor) VALUES (? , 'evil')";
            insertIntoDatabase(query, villainInfo);

            System.out.printf("Villain %s was added to the database.%n", villainInfo);
        }

        String idOfTown = findEntityByFieldQuery(minionInfo[2], "SELECT id FROM towns WHERE name = ?", "id");
        query = String.format("INSERT INTO minions(name, age, town_id) VALUES ('%s', '%s', ?)", minionInfo[0], minionInfo[1]);

        insertIntoDatabase(query, idOfTown);

        String idOfMinion = findEntityByFieldQuery(minionInfo[0], "SELECT id FROM minions WHERE name = ?", "id");
        String idOfVillain = findEntityByFieldQuery(villainInfo, "SELECT id FROM villains WHERE name = ?", "id");

        query = String.format("INSERT INTO minions_villains (minion_id, villain_id) VALUES(%s, ?)", idOfMinion);
        insertIntoDatabase(query, idOfVillain);

        System.out.printf("Successfully added %s to be minion of %s%n", villainInfo, minionInfo[0]);
    }

    private static void exNine() throws IOException, SQLException {

        System.out.print("Please choose minion id to update age + 1:");
        String minionId = reader.readLine();

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setString(1, minionId);
        callableStatement.executeUpdate();

        query = "SELECT name, age FROM minions WHERE id = ?";

        preparedStatement = getPreparedStatement(connection, query);
        preparedStatement.setString(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
    }

    private static void exSix() throws IOException, SQLException {

        System.out.print("Please choose villain id, to be deleted from Database:");
        String villainId = reader.readLine();

        String villainName = findEntityByFieldQuery(villainId, "SELECT name FROM villains WHERE id = ?", "name");

        if (villainName == null) {
            System.out.println("No such villain was found");
            return;
        } else {
            System.out.println(villainName + " was deleted");
        }

        query = "DELETE FROM minions_villains WHERE villain_id = ?;";
        preparedStatement = getPreparedStatement(connection, query);
        preparedStatement.setString(1, villainId);

        System.out.println(preparedStatement.executeUpdate() + " minions released");
    }

    private static void exEight() throws SQLException, IOException {
        query = "UPDATE minions SET age = age +1 WHERE id = ?;";

        preparedStatement = getPreparedStatement(connection, query);

        System.out.println("Select minion id to update age +1 separated by white space:");
        String[] ids = reader.readLine().split(" ");

        for (String id : ids) {
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        }

        query = "SELECT name, age FROM minions;";
        preparedStatement = getPreparedStatement(connection, query);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
        }
    }

    private static void exSeven() throws SQLException {

        query = "SELECT name FROM minions;";
        preparedStatement = getPreparedStatement(connection, query);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayDeque<String> deque = new ArrayDeque<>();

        while (resultSet.next()) {
            deque.push(resultSet.getString("name"));
        }

        while (!deque.isEmpty()) {
            System.out.println(deque.pollLast());
            System.out.println(deque.poll());
        }
    }

    private static void exFive() throws SQLException, IOException {
        query = "UPDATE towns SET name = UPPER(name) WHERE country = ?;";
        PreparedStatement preparedStatementUpdate = getPreparedStatement(connection, query);

        System.out.print("Please choose country:");
        String country = reader.readLine();
        preparedStatementUpdate.setString(1, country);

        int affRows = preparedStatementUpdate.executeUpdate();
        if (affRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }
        System.out.println(affRows + " town names were affected.");

        query = "SELECT name FROM towns WHERE country = ?;";

        PreparedStatement preparedStatementSelect = getPreparedStatement(connection, query);
        preparedStatementSelect.setString(1, country);
        ResultSet resultSet = preparedStatementSelect.executeQuery();


        List<String> towns = new ArrayList<>();

        while (resultSet.next()) {
            towns.add(resultSet.getString("name"));
        }
        System.out.printf("[%s]%n", String.join(", ", towns));
    }

    private static void exThree() throws SQLException, IOException {
        query = """
                SELECT v.name, m.name ,m.age FROM villains v
                JOIN minions_villains mv on v.id = mv.villain_id
                JOIN minions m on m.id = mv.minion_id
                WHERE v.id = ?;""";
        preparedStatement = getPreparedStatement(connection, query);

        System.out.print("Please, choose id of villain:");
        String id = reader.readLine();

        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (findEntityByFieldQuery(id, "SELECT name FROM villains WHERE id = ?", "name") == null) {
            System.out.println("No villain with ID " + id + " exists in the database.");
            return;
        }
        System.out.printf("Villain: %s%n", findEntityByFieldQuery(id, "SELECT name FROM villains WHERE id = ?", "name"));

        int counter = 0;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", ++counter, resultSet.getString("m.name"), resultSet.getInt("age"));
        }

    }

    private static String findEntityByFieldQuery(String field, String query, String column) throws SQLException {

        String result;

        preparedStatement = getPreparedStatement(connection, query);
        preparedStatement.setString(1, field);
        ResultSet resultSet = preparedStatement.executeQuery();
        try {
            resultSet.next();
            result = resultSet.getString(column);
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    private static PreparedStatement getPreparedStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    private static void exTwo() throws SQLException {

        query = """
                SELECT v.name, COUNT(DISTINCT mv.minion_id) m_count FROM villains v
                JOIN minions_villains mv on v.id = mv.villain_id
                GROUP BY v.name
                HAVING m_count > ?
                ORDER BY m_count DESC;""";

        preparedStatement = getPreparedStatement(connection, query);
        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("m_count"));
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        System.out.print("Enter user:");
        String user = reader.readLine();
        System.out.print("Enter password:");
        String password = reader.readLine();

        Properties prop = new Properties();
        prop.setProperty("user", user);
        prop.setProperty("password", password);
        return DriverManager.getConnection(URL + DB_NAME, prop);
    }

    public static void insertIntoDatabase(String query, String fieldToInsert) throws SQLException {
        preparedStatement = getPreparedStatement(connection, query);
        preparedStatement.setString(1, fieldToInsert);

        preparedStatement.executeUpdate();
    }
}
