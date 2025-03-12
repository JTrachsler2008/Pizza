package Pizza;

public class PizzaStart {
    public static void main(String[] args) {
        System.out.println("\n==============================================");
        System.out.println("PIZZA BESTELLUNGSSYSTEM STARTET...");
        System.out.println("==============================================\n");

        Email email1 = new Email("joel.trachsler@example.com");
        Adress adresse1 = new Adress("Musterstrasse 1, 8000 Zürich");

        Email email2 = new Email("max.mustermann@example.com");
        Adress adresse2 = new Adress("Hauptstrasse 1, 8000 Zürich");

        Customer kunde1 = new Customer(1, "Joël Trachsler", email1, adresse1);
        Customer kunde2 = new Customer(2, "Max Mustermann", email2, adresse2);

        OrderManager orderManager = new OrderManager();

        Order order1 = new Order(1, kunde1.getCustomerId());
        order1.add(Factory.create(PizzaType.FUNGHI));
        order1.add(Factory.create(PizzaType.MARGHERITA));
        orderManager.addOrder(order1);

        Order order2 = new Order(2, kunde2.getCustomerId());
        order2.add(Factory.create(PizzaType.SALAMI));
        order2.add(Factory.create(PizzaType.MARGHERITA));
        orderManager.addOrder(order2);

        kunde1.showCustomerInfo();
        orderManager.showOrdersForCustomer(kunde1.getCustomerId());

        System.out.println();

        kunde2.showCustomerInfo();
        orderManager.showOrdersForCustomer(kunde2.getCustomerId());

        System.out.println("ALLE BESTELLUNGEN ANGEZEIGT.");
    }
}
