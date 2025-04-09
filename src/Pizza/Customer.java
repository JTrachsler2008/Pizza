package Pizza;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "customers")
public class Customer {

    private static final Logger logger = Logger.getLogger(Customer.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private Email email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Adress adresse;

    public Customer() {}

    public Customer(String name, Email email, Adress adresse) {
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        logger.info("Neuer Kunde erstellt: " + name);
    }

    public int getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getAdress() {
        return adresse.getAddress();
    }

    public void showCustomerInfo() {
        logger.info("----------------------------------------------");
        logger.info("Kunde: " + name);
        logger.info("E-Mail: " + getEmail());
        logger.info("Adresse: " + getAdress());
    }
}
