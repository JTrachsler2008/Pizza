package Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private final int customerId;
    private final String name;
    private final Email email;
    private final Adress adresse;

    public Customer(int customerId, String name, Email email, Adress adresse, Connection connection) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        saveToDatabase(connection);
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getAdress() {
        return adresse.getAddress();

    }

    public void showCustomerInfo() {
        System.out.println("----------------------------------------------");
        System.out.println("Kunde: " + name);
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Adresse: " + getAdress());
    }

    // Speichern des Kunden mit Adresse in der Datenbank
    public void saveToDatabase(Connection connection) {
        try {

            String insertAddressSql = "INSERT INTO addresses (address) VALUES (?)";
            try (PreparedStatement stmt = connection.prepareStatement(insertAddressSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, this.adresse.getAddress());
                stmt.executeUpdate();

                int addressId = -1;
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        addressId = generatedKeys.getInt(1);
                    }
                }

                String insertEmailSql = "INSERT INTO emails (email) VALUES (?)";
                try (PreparedStatement emailStmt = connection.prepareStatement(insertEmailSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    emailStmt.setString(1, this.email.getEmail());
                    emailStmt.executeUpdate();

                    int emailId = -1;
                    try (ResultSet emailGeneratedKeys = emailStmt.getGeneratedKeys()) {
                        if (emailGeneratedKeys.next()) {
                            emailId = emailGeneratedKeys.getInt(1);
                        }
                    }

                    if (addressId != -1 && emailId != -1) {
                        String insertCustomerSql = "INSERT INTO customers (id, name, email_id, address_id) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement customerStmt = connection.prepareStatement(insertCustomerSql)) {
                            customerStmt.setInt(1, this.customerId);
                            customerStmt.setString(2, this.name);
                            customerStmt.setInt(3, emailId);
                            customerStmt.setInt(4, addressId);
                            customerStmt.executeUpdate();
                            System.out.println("Kunde gespeichert: " + name);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern des Kunden oder der Adresse: " + e.getMessage());
        }
    }

}
