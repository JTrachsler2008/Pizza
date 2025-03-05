package Pizza;

public class PizzaKunde {
    private final String name;
    private final KundeEmail email;
    private final KundeAdresse adresse;
    private final Bestellung[] bestellungen;
    private int bestellungCount;

    public PizzaKunde(String name, KundeEmail email, KundeAdresse adress) {
        this.name = name;
        this.email = email;
        this.adresse = adress;
        this.bestellungen = new Bestellung[10]; // Maximal 10 Bestellungen
        this.bestellungCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getAdress() {
        return adresse.getAddress();
    }

    public void add(Bestellung bestellung) {
        if (bestellungCount < bestellungen.length) {
            bestellungen[bestellungCount] = bestellung;
            bestellungCount++;
            System.out.println("Bestellung für " + name + " wurde gemacht.");
        } else {
            System.out.println("Maximale Anzahl an Bestellungen erreicht.");
        }
    }

    public void showAll() {
        System.out.println("Kunde: " + name);
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Adresse: " + getAdress());
        for (int i = 0; i < bestellungCount; i++) {
            bestellungen[i].show();
        }
    }
}
