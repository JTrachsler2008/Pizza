package Pizza;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "emails")
public class Email {

    private static final Logger logger = Logger.getLogger(Email.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    // Standardkonstruktor für JPA
    public Email() {}

    // Konstruktor für E-Mail-Objekte
    public Email(String email) {
        this.email = email;
        logger.info("Neue E-Mail erstellt: " + email);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        logger.info("E-Mail aktualisiert: " + email);
        this.email = email;
    }
}
