package Pizza;

import java.util.logging.Logger;

class PizzaSalami extends Pizza {
    private static final Logger logger = Logger.getLogger(PizzaSalami.class.getName());

    public PizzaSalami() {
        super(PizzaTyp.SALAMI);
        top();
    }

    public void top() {
        //logger.info("Die Pizza wird mit Salami belegt.");
        System.out.println("Die Pizza wird mit Salami belegt.");
    }
}
