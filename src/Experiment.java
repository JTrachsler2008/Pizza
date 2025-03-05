public class Experiment {

    public void logicalNot() {
        boolean a = true;
        boolean b = false;

        System.out.println(!a); // Ausgabe: false
        System.out.println(!b); // Ausgabe: true
    }

    public void andShortCircuit() {
        int a = 10;
        int b = 5;

        if (a > 5 && b < 10) {
            System.out.println("&&: Beide sind true!");
        } else {
            System.out.println("&&: Eine oder beide sind false");
        }
    }

    public void orShortCircuit() {
        int a = 10;
        int b = 5;

        if (a > 5 || b < 3) {
            System.out.println("||: Mindestens eine ist true");
        } else {
            System.out.println("||: Beide sind falsch");
        }
    }

    public void andNoShortCircuit() {
        int a = 10;
        int b = 5;

        if (a > 5 & b < 3) {
            System.out.println("&: Beide sind true!");
        } else {
            System.out.println("&: Eine oder beide false!");
        }
    }

    public void orNoShortCircuit() {
        int a = 10;
        int b = 5;

        if (a > 5 | b < 3) {
            System.out.println("|: Mindestens einer ist richtig");
        } else {
            System.out.println("|: Beide sind falsch");
        }
    }

    public void summe(int... zahlen) {
        int summe = 0;
        for (int zahl : zahlen) {
            summe += zahl;
        }
        System.out.println("Summe der Zahlen: " + summe);
    }




}

//Vergleichsoperatoren fertig,, doppelte Operatoren fertig, Methoden mit ... fertig, Singleton in Java Design Pattern, static (private Konstruktoren)