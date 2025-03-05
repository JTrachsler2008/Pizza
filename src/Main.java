
import java.util.Arrays;

public class Main {

    String demo = "demo";


    int y = 2;
    int z;
    int x;

    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        experiment.logicalNot();


        experiment.andShortCircuit();


        experiment.orShortCircuit();


        experiment.andNoShortCircuit();


        experiment.orNoShortCircuit();

        experiment.summe(1, 2, 3);
        experiment.summe(4, 5, 6, 7, 8);

        MySingleton a = MySingleton.getInstance();
        MySingleton b = MySingleton.getInstance();

        System.out.println("Value of a.x = " + a.x);
        System.out.println("Value of b.x = " + b.x);


        Test test = new Test();
        int[] numbers = {1, 2, 3, 4};

        int[][] numbers2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        int[] numbers3 = new int[4];

        int x = 7;

        System.out.println("Antwort:" + x / 2);

        numbers[0] = 13;

        int[] numbersCopy = numbers.clone();

        System.out.println(Arrays.toString(numbersCopy));

        System.out.println(Arrays.toString(numbers3));

        // hashcode, equals / (==), clone

        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {4, 5, 6};


        System.out.println(Arrays.equals(array1, array2)); //true
        System.out.println(Arrays.equals(array1, array3)); // false

        int hashCode1 = Arrays.hashCode(array1);
        int hashCode2 = Arrays.hashCode(array2);
        int hashCode3 = Arrays.hashCode(array3);

        System.out.println("HashCode von array1: " + hashCode1);
        System.out.println("HashCode von array2: " + hashCode2);
        System.out.println("HashCode von array3: " + hashCode3);


        System.out.println(numbers2[2][3]);

        System.out.println(numbers[3]);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }


        Main main = new Main();
        main.demo();
        main.setY(17);
        System.out.println("Equals: " + main.equals(main.demo));
        System.out.println(main.getY());

        //Test test = new Test(5);

        Test test1 = new Test();
/*
        test = test1;
        test1 = null;
*/
        Test test2 = new Test();

        Double d1 = Double.valueOf(3.14);

        Float f1 = Float.valueOf(3.144F);

        Integer i1 = Integer.valueOf(12);

        Integer i2 = Integer.valueOf(12);
        String gugus;
        if (i1.doubleValue() == 12) {
            gugus = "gugus";
            System.out.println("12");
        }

        //  i1.doubleValue() == 12 ? gugus = "gugus" : gugus = "sonstwas"


        test.test();

        test1.test(234);

        test2.test();

        /*
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        if (args.length == 0) {
            System.out.println("Keine Elemente");
        } else {
            System.out.println(args[0]);
        }
*/
    }

    private void setY(int y) {
        this.y = y;
    }

    private int getY() {
        return y;
    }

    public void demo() {
       /* System.out.println(demo);
        demo();
*/
    }

}

// Main.java: C:\dev\Java\win64_openjdk17.0.9_9\bin\java.exe Main.java

// Main.class: C:\dev\Java\win64_openjdk17.0.9_9\bin\java.exe Main