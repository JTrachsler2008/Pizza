package Pizza;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderManager {
    private final Order[] orders = new Order[10];
    private int orderCount = 0;

    public void addOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount] = order;
            orderCount++;
            saveOrderToDatabase(order);
            System.out.println("Bestellung " + order.getOrderId() + " für Kunde " + order.getCustomerId() + " wurde registriert.");
        } else {
            System.out.println("Maximale Anzahl an Bestellungen erreicht.");
        }
    }

    private void saveOrderToDatabase(Order order) {
        try (Connection connection = DatabaseManager.getConnection()) {
            order.saveToDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showOrdersForCustomer(int customerId) {
        System.out.println("Bestellungen für Kunde ID: " + customerId);
        boolean found = false;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomerId() == customerId) {
                orders[i].showOrder();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Keine Bestellungen für diesen Kunden gefunden.");
        }
    }
}
