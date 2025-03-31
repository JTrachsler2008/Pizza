package Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderId;
    private final int customerId;
    private final List<Pizza> pizzen = new ArrayList<>();

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void add(Pizza pizza) {
        pizzen.add(pizza);
        System.out.println("Pizza " + pizza.getName() + " wurde zur Bestellung hinzugefügt.");
    }

    public double calculateTotal() {
        return pizzen.stream().mapToDouble(Pizza::getPrice).sum();
    }

    public void showOrder() {
        System.out.println("Bestellung ID: " + orderId + " für Kunde ID: " + customerId);
        for (Pizza pizza : pizzen) {
            pizza.bake();
            pizza.showPrice();
        }
        System.out.println("Gesamtpreis: " + calculateTotal() + " Franken.");
        System.out.println("----------------------------------------------");
    }

    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzen);
    }

    public void saveToDatabase(Connection connection) {
        String sql = "MERGE INTO orders (id, customer_id, total_price) KEY(id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.orderId);
            stmt.setInt(2, this.customerId);
            stmt.setDouble(3, calculateTotal());
            stmt.executeUpdate();
            System.out.println("Bestellung gespeichert.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern der Bestellung: " + e.getMessage());
        }
    }
}
