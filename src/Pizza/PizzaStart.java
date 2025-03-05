package Pizza;

import java.util.logging.Logger;

public class PizzaStart {
    private static final Logger logger = Logger.getLogger(PizzaStart.class.getName());

    public static void main(String[] args) {
        //logger.info("PizzaStart wird gestartet.");
        System.out.println("----------------------------------------------");

        KundeEmail email1 = new KundeEmail("joel.trachsler@example.com");
        KundeAdresse adresse1 = new KundeAdresse("Musterstrasse 1, 8000 Zürich");

        KundeEmail email2 = new KundeEmail("max.mustermann@example.com");
        KundeAdresse adresse2 = new KundeAdresse("Hauptstrasse 1, 8000 Zürich");

        PizzaKunde kunde = new PizzaKunde("Joël Trachsler", email1, adresse1);
        PizzaKunde kunde1 = new PizzaKunde("Max Mustermann", email2, adresse2);

        Bestellung bestellung1 = new Bestellung();
        bestellung1.add(PizzaFactory.create(PizzaTyp.FUNGHI));
        bestellung1.add(PizzaFactory.create(PizzaTyp.MARGHERITA));
        kunde.add(bestellung1);

        kunde.showAll();

        Bestellung bestellung3 = new Bestellung();
        bestellung3.add(PizzaFactory.create(PizzaTyp.SALAMI));
        bestellung3.add(PizzaFactory.create(PizzaTyp.MARGHERITA));
        kunde1.add(bestellung3);

        kunde1.showAll();

        FunnyImpl funny = new FunnyImpl();
        funny.print();
        funny.write();

        TestImpl test = new TestImpl();
        test.print();

        System.out.println( test.getPrice());


        //logger.info("PizzaStart abgeschlossen.");
    }
}
