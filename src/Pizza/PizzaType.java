package Pizza;

import java.util.logging.Logger;

public enum PizzaType {
    FUNGHI("Funghi", 12.5),
    MARGHERITA("Margherita", 10.0),
    SALAMI("Salami", 13.0);

    private static final Logger logger = Logger.getLogger(PizzaType.class.getName());
    private final String name;
    private final double price;

    PizzaType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
