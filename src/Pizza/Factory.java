package Pizza;


import java.util.logging.Logger;

public class Factory {

    private static final Logger logger = Logger.getLogger(Factory.class.getName());

    /**
     * @param type
     * @return
     */
    public static Pizza create(PizzaType type) {
        //logger.info("Erstelle eine Pizza vom Typ: " + type.getName());
        switch (type) {
            case FUNGHI:
                return new PizzaFunghi();
            case MARGHERITA:
                return new PizzaMargherita();
            case SALAMI:
                return new PizzaSalami();
        }

        return null;
    }
}