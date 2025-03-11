package Pizza;

public class OrderManager {
    private final Order[] orders = new Order[10];
    private int orderCount = 0;

    public void addOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount] = order;
            orderCount++;
            System.out.println("Bestellung " + order.getOrderId() + " für Kunde " + order.getCustomerId() + " wurde registriert.");
        } else {
            System.out.println("Maximale Anzahl an Bestellungen erreicht.");
        }
    }

    public void showOrdersForCustomer(int customerId) {
        System.out.println("Bestellungen für Kunde ID: " + customerId);
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomerId() == customerId) {
                orders[i].showOrder();
            }
        }
    }
}
