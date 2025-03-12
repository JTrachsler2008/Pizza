package H2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DatabaseExample {
    public static void main(String[] args) throws SQLException {

        String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "";

        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
        System.out.println("Verbindung zur H2-Datenbank erfolgreich!");

        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "email VARCHAR(255))";

        Statement stmt = connection.createStatement();
        stmt.execute(createTableSQL);
        System.out.println("Tabelle 'users' wurde erfolgreich erstellt.");

        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, "Max Mustermann");
        preparedStatement.setString(2, "max@example.com");
        preparedStatement.setString(1, "Joël Trachsler");
        preparedStatement.setString(2, "trachsler@example.com");
        preparedStatement.executeUpdate();
        System.out.println("Daten wurden erfolgreich eingefügt.");

        connection.close();
    }
}
