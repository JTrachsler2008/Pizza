package Pizza;

import java.sql.Connection;
import java.sql.SQLException;

public class PizzaStart {
    public static void main(String[] args) {
        System.out.println("\n==============================================");
        System.out.println("PIZZA BESTELLUNGSSYSTEM STARTET...");
        System.out.println("==============================================\n");

        try (Connection connection = DatabaseManager.getConnection()) {
            PizzaType.insertPizzasIntoDatabase();

            Email email1 = new Email("joel.trachsler@example.com");
            Adress adresse1 = new Adress("Musterstrasse 1, 8000 Zürich");

            Email email2 = new Email("max.mustermann@example.com");
            Adress adresse2 = new Adress("Hauptstrasse 1, 8000 Zürich");

            Email email3 = new Email("daniel.mustermann@example.com");
            Adress adresse3 = new Adress("Hauptstrasse 2, 8000 Zürich");

            Customer kunde1 = new Customer(1, "Joël Trachsler", email1, adresse1, connection);
            Customer kunde2 = new Customer(2, "Max Mustermann", email2, adresse2, connection);
            Customer kunde3 = new Customer(3, "Daniel Mustermann", email3, adresse3, connection);

            OrderManager orderManager = new OrderManager();


            Order order1 = new Order(1, kunde1.getCustomerId());
            order1.add(Factory.create(PizzaType.FUNGHI));
            order1.add(Factory.create(PizzaType.MARGHERITA));
            orderManager.addOrder(order1);

            Order order2 = new Order(2, kunde2.getCustomerId());
            order2.add(Factory.create(PizzaType.SALAMI));
            order2.add(Factory.create(PizzaType.MARGHERITA));
            orderManager.addOrder(order2);

            Order order3 = new Order(3, kunde3.getCustomerId());
            order3.add(Factory.create(PizzaType.SALAMI));
            order3.add(Factory.create(PizzaType.MARGHERITA));
            orderManager.addOrder(order3);

            kunde1.showCustomerInfo();
            orderManager.showOrdersForCustomer(kunde1.getCustomerId());

            System.out.println();

            kunde2.showCustomerInfo();
            orderManager.showOrdersForCustomer(kunde2.getCustomerId());


            kunde3.showCustomerInfo();
            orderManager.showOrdersForCustomer(kunde3.getCustomerId());


            System.out.println("ALLE BESTELLUNGEN ANGEZEIGT.");

        } catch (SQLException e) {
            System.out.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }
    }
}
