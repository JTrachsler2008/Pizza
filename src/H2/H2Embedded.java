package H2;

import java.sql.*;

public class H2Embedded {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:~/test"; // Embedded Version
        String user = "sa";
        String password = "";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "email VARCHAR(255))";

        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
        String selectSQL = "SELECT * FROM users";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
             Statement stmt = connection.createStatement()) {

            System.out.println("Verbindung zur H2-Datenbank erfolgreich!");


            stmt.execute(createTableSQL);
            System.out.println("Tabelle 'users' wurde erfolgreich erstellt.");


            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                insertUser(preparedStatement, "Daniel Meier", "max@example.com");

                System.out.println("Daten wurden erfolgreich eingefügt.");
            }


            try (Statement selectStmt = connection.createStatement();
                 ResultSet resultSet = selectStmt.executeQuery(selectSQL)) {

                System.out.println("\nGespeicherte Benutzer in der Datenbank:");


                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.printf("%d  | %s | %s%n", id, name, email);
                }
            }

        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankverarbeitung: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\nDatenbankoperationen abgeschlossen.");
        }
    }

    private static void insertUser(PreparedStatement preparedStatement, String name, String email) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();
    }
}
