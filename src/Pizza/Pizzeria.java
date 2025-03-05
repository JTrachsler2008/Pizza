package Pizza;

import java.util.logging.Logger;

public class Pizzeria {

    private static final Logger logger = Logger.getLogger(Pizzeria.class.getName());

    public void pizzeria() {
       //logger.info("Pizzeria wird gestartet...");

        Pizza[] pizzen = new Pizza[3];

        pizzen[0] = PizzaFactory.create(PizzaTyp.FUNGHI);
        pizzen[1] = PizzaFactory.create(PizzaTyp.MARGHERITA);
        pizzen[2] = PizzaFactory.create(PizzaTyp.SALAMI);

        for (Pizza pizza : pizzen) {
            pizza.bake();
            pizza.showPrice();
        }

        //logger.info("Pizzeria abgeschlossen.");
    }
}
