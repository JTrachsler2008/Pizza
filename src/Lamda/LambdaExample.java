package Lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<String> upperCaseNames = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Grossbuchstaben: " + upperCaseNames);


        names.forEach(name -> System.out.println(name + " hat " + name.length() + " Buchstaben"));


        List<String> longNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Lange Namen (>4 Buchstaben): " + longNames);


        long count = names.stream().count();
        System.out.println("Anzahl der Namen: " + count);
    }
}
