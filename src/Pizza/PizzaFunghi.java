package Pizza;

import java.util.logging.Logger;

class PizzaFunghi extends Pizza {
    private static final Logger logger = Logger.getLogger(PizzaFunghi.class.getName());

    public PizzaFunghi() {
        super(PizzaType.FUNGHI);
        top();
    }

    public void top() {
        //logger.info("Die Pizza wird mit Pilzen belegt.");
        System.out.println("Die Pizza wird mit Pilzen belegt.");
    }
}
