package Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExample {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Max");
        names.add("Daniel");
        names.add("Joël");

        names.forEach(name -> System.out.println("Name: " + name));

        names.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(name -> System.out.println("Gefiltert: " + name));
    }
}
