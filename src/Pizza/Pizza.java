package Pizza;

import java.util.logging.Logger;

public class Pizza {
    private static final Logger logger = Logger.getLogger(Pizza.class.getName());
    private final PizzaTyp type;

    public Pizza(PizzaTyp type) {
        this.type = type;
    }

    public void bake() {
        //logger.info("Die Pizza " + typ.getName() + " wird gebacken.");
        System.out.println("Die Pizza " + type.getName() + " wird gebacken.");
    }

    public void showPrice() {
        //logger.info("Der Preis der Pizza " + typ.getName() + " ist " + typ.getPreis() + " Franken.");
        System.out.println("Der Preis der Pizza " + type.getName() + " ist " + type.getPrice() + " Franken.");
    }

    public double getPrice() {
        return type.getPrice();
    }

    public String getName() {
        return type.getName();
    }
}
