package Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Pizza {
    private static final Logger logger = Logger.getLogger(Pizza.class.getName());
    private final PizzaType type;
    private int pizzaId;

    public Pizza(PizzaType type) {
        this.type = type;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public void bake() {
        System.out.println("Die Pizza " + type.getName() + " wird gebacken.");
    }

    public void showPrice() {
        System.out.println("Der Preis der Pizza " + type.getName() + " ist " + type.getPrice() + " Franken.");
    }


    public double getPrice() {
        return type.getPrice();
    }

    public String getName() {
        return type.getName();
    }

    public void saveToDatabase(Connection connection) {
        String sql = "MERGE INTO pizzas (id, type, price) KEY(id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.pizzaId);
            stmt.setString(2, this.getName());
            stmt.setDouble(3, this.getPrice());
            stmt.executeUpdate();
            System.out.println("Pizza gespeichert: " + this.getName());
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern der Pizza: " + e.getMessage());
        }
    }
}
