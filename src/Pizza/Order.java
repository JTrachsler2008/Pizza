package Pizza;

public class Order {
    private final int orderId;
    private final int customerId;
    private final Pizza[] pizzen = new Pizza[10];
    private int pizzaCount = 0;

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
        if (pizzaCount < pizzen.length) {
            pizzen[pizzaCount] = pizza;
            pizzaCount++;
            System.out.println("Pizza " + pizza.getName() + " wurde zur Bestellung hinzugefügt.");
        } else {
            System.out.println("Maximale Anzahl an Pizzen erreicht.");
        }
    }

    public double calculateTotal() {
        double totalPrice = 0;
        for (int i = 0; i < pizzaCount; i++) {
            totalPrice += pizzen[i].getPrice();
        }
        return totalPrice;
    }

    public void showOrder() {
        System.out.println("Bestellung ID: " + orderId + " für Kunde ID: " + customerId);
        for (int i = 0; i < pizzaCount; i++) {
            pizzen[i].bake();
            pizzen[i].showPrice();
        }
        System.out.println("Gesamtpreis: " + calculateTotal() + " Franken.");
        System.out.println("----------------------------------------------");
    }
}

// H2DB verbinden und testen Embedded und Stand alone, Maven anschauen, Tomcat anschauen,