import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter salary:");
        double salary = Double.parseDouble(sc.nextLine());

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni","...","...");

        PreparedStatement stm = connection.prepareStatement("SELECT first_name, last_name FROM employees WHERE salary > ?");
        stm.setDouble(1, salary);

        ResultSet resultSet = stm.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") +
                    " " + resultSet.getString("last_name"));
        }
    }
}
