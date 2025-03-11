package Pizza;

import java.util.logging.Logger;

public class Pizzeria {

    private static final Logger logger = Logger.getLogger(Pizzeria.class.getName());

    public void pizzeria() {
       //logger.info("Pizzeria wird gestartet...");

        Pizza[] pizzen = new Pizza[3];

        pizzen[0] = Factory.create(PizzaType.FUNGHI);
        pizzen[1] = Factory.create(PizzaType.MARGHERITA);
        pizzen[2] = Factory.create(PizzaType.SALAMI);

        for (Pizza pizza : pizzen) {
            pizza.bake();
            pizza.showPrice();
        }

        //logger.info("Pizzeria abgeschlossen.");
    }
}
