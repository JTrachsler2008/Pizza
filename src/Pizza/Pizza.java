package Pizza;

import java.util.logging.Logger;

/**
 * The type Pizza.
 */
public class Pizza {
    private static final Logger logger = Logger.getLogger(Pizza.class.getName());
    private final PizzaType type;

    /**
     * Instantiates a new Pizza.
     *
     * @param type the type
     */
    public Pizza(PizzaType type) {
        this.type = type;
    }

    /**
     * Bake.
     */
    public void bake() {
        //logger.info("Die Pizza " + typ.getName() + " wird gebacken.");
        System.out.println("Die Pizza " + type.getName() + " wird gebacken.");
    }

    /**
     * Show price.
     */
    public void showPrice() {
        //logger.info("Der Preis der Pizza " + typ.getName() + " ist " + typ.getPreis() + " Franken.");
        System.out.println("Der Preis der Pizza " + type.getName() + " ist " + type.getPrice() + " Franken.");
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return type.getPrice();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return type.getName();
    }
}
