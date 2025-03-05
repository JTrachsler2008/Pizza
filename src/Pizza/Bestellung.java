package Pizza;

public class Bestellung {
    private final Pizza[] pizzen = new Pizza[10];
    private int pizzaCount;

    /**
     * Pizza zur Bestellung hinzufügen
     * @param pizza
     */

    public void add(Pizza pizza) {
        if (pizzaCount < pizzen.length) {
            pizzen[pizzaCount] = pizza;
            pizzaCount++;
            System.out.println("Pizza " + pizza.getName() + " wurde zur Bestellung hinzugefügt.");
        } else {
            System.out.println("Es können keine weiteren Pizzen zur Bestellung hinzugefügt werden.");
        }
    }

    /**
     *
     * @return
     */
    public double calculate() {
        double totalPrice = 0;
        for (int i = 0; i < pizzaCount; i++) {
            totalPrice += pizzen[i].getPrice();
        }
        return totalPrice;
    }

    /**
     *
     */
    public void show() {
        for (int i = 0; i < pizzaCount; i++) {
            pizzen[i].bake();
            pizzen[i].showPrice();
        }
        System.out.println("Gesamtpreis: " + calculate() + " Franken.");
        System.out.println("----------------------------------------------");
    }
}

// |Interface|, |Konventionen| , |Array statt ArrayList| , |Adresse und E-Mail|

// Collections, Doku,
