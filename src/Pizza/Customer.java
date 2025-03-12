package Pizza;

public class Customer {
    private final int customerId;
    private final String name;
    private final Email email;
    private final Adress adresse;

    public Customer(int customerId, String name, Email email, Adress adress) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.adresse = adress;
    }

    public int getCustomerId() {
        return customerId;
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

    public void showCustomerInfo() {
        System.out.println("----------------------------------------------");
        System.out.println("Kunde: " + name);
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Adresse: " + getAdress());

    }
}
