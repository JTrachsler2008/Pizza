package Pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf;

    public static synchronized EntityManager getEntityManager() {
        if (emf == null) {
            try {
                System.out.println("Initialisiere EntityManagerFactory für 'PizzaPU'");
                emf = Persistence.createEntityManagerFactory("PizzaPU");
            } catch (Exception e) {
                System.out.println("Fehler von JPA: ");
                throw new IllegalStateException("JPA nicht verfügbar.", e);
            }
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
