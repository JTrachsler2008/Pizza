package Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public enum PizzaType {
    FUNGHI("Funghi", 12.5),
    MARGHERITA("Margherita", 10.0),
    SALAMI("Salami", 13.0);

    private static final Logger logger = Logger.getLogger(PizzaType.class.getName());
    private final String name;
    private final double price;

    PizzaType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Diese Methode speichert alle Pizzen in die Datenbank
    public static void insertPizzasIntoDatabase() {
        String sql = "MERGE INTO pizzas (id, type, price) KEY(id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            for (PizzaType pizza : PizzaType.values()) {
                stmt.setInt(1, pizza.ordinal() + 1);  // ID basierend auf der Enum-Reihenfolge
                stmt.setString(2, pizza.getName());
                stmt.setDouble(3, pizza.getPrice());
                stmt.executeUpdate();
            }

            System.out.println("Pizzas erfolgreich in die Datenbank eingefügt.");

        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen der Pizzas: " + e.getMessage());
        }


}
}
