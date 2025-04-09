package Pizza;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "addresses")
public class Adress {

    private static final Logger logger = Logger.getLogger(Adress.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address", nullable = false)
    private String address;

    public Adress() {}

    public Adress(String address) {
        this.address = address;
        logger.info("Neue Adresse erstellt: " + address);
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        logger.info("Adresse aktualisiert: " + address);
        this.address = address;
    }
}
