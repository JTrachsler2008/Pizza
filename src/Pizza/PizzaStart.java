package Pizza;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PizzaStart {

    private static final Logger logger = Logger.getLogger(PizzaStart.class.getName());

    public static void main(String[] args) {
        logger.info("==============================================");
        logger.info("PIZZA BESTELLUNGSSYSTEM STARTET...");
        logger.info("==============================================");

        try (Connection connection = DatabaseManager.getConnection()) {
            PizzaType.insertPizzasIntoDatabase();
            logger.info("Pizzas wurden in die Datenbank eingefügt.");

            EntityManager em = JpaUtil.getEntityManager();
            try {
                logger.info("Initialisiere EntityManagerFactory für 'PizzaPU'");
                em.getTransaction().begin();

                Email email1 = findOrCreateEmail(em, "joel.trachsler@example.com");
                Adress adresse1 = new Adress("Musterstrasse 1, 8000 Zürich");
                Customer kunde1 = new Customer("Joël Trachsler", email1, adresse1);

                Email email2 = findOrCreateEmail(em, "max.mustermann@example.com");
                Adress adresse2 = new Adress("Hauptstrasse 1, 8000 Zürich");
                Customer kunde2 = new Customer("Max Mustermann", email2, adresse2);

                Email email3 = findOrCreateEmail(em, "daniel.mustermann@example.com");
                Adress adresse3 = new Adress("Hauptstrasse 2, 8000 Zürich");
                Customer kunde3 = new Customer("Daniel Mustermann", email3, adresse3);

                em.persist(kunde1);
                em.persist(kunde2);
                em.persist(kunde3);

                em.getTransaction().commit();
                logger.info("Kunden erfolgreich gespeichert.");

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

                kunde2.showCustomerInfo();
                orderManager.showOrdersForCustomer(kunde2.getCustomerId());

                kunde3.showCustomerInfo();
                orderManager.showOrdersForCustomer(kunde3.getCustomerId());

                logger.info("Alle Bestellungen wurden angezeigt.");

            } catch (Exception e) {
                em.getTransaction().rollback();
                logger.log(Level.SEVERE, "Fehler während der Transaktion: ", e);
            } finally {
                em.close();
                logger.info("EntityManager geschlossen.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Fehler bei der Datenbankverbindung: ", e);
        }
    }

    private static Email findOrCreateEmail(EntityManager em, String emailStr) {
        TypedQuery<Email> query = em.createQuery("SELECT e FROM Email e WHERE e.email = :email", Email.class);
        query.setParameter("email", emailStr);
        return query.getResultStream().findFirst().orElse(new Email(emailStr));
    }
}
