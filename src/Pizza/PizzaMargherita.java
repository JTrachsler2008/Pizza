package Pizza;

import java.util.logging.Logger;

class PizzaMargherita extends Pizza {
    private static final Logger logger = Logger.getLogger(PizzaMargherita.class.getName());

    public PizzaMargherita() {
        super(PizzaType.MARGHERITA);
        top();
    }

    public void top() {
        //logger.info("Die Pizza wird mit Tomaten und Mozzarella belegt.");
        System.out.println("Die Pizza wird mit Tomaten und Mozzarella belegt.");
    }
}
