package misc_topics.lambdas;

import java.util.*;
import java.util.function.Predicate;

public class LambdaJavaFunctions {
    public static void main(String[] args) {
        //create a list of persons
        List<Person> peopleList = new ArrayList(Arrays.asList(
                new Person("Paul", "Rudd", 32, "New York"),
                new Person("Bruce", "Willis", 50, "LA"),
                new Person("Hanna", "Montana", 20, "LA")
        ));

        //Situation - we need to print persons from list based on various scenarios
        //so create a scenario interface/ or use one of the built in Java functional interfaces
        // Print all who have first name starting with P or H
        printFirstNameConditional(peopleList, (p-> p.getFirstName().startsWith("P") || p.getFirstName().startsWith("H")));

        //Sort list by last name
        System.out.println("\nPeople over the age of 30");
        Collections.sort(peopleList, Comparator.comparing(Person::getLastName));

        //Print all elements of the list for people over 30
        printFirstNameConditional(peopleList, p-> p.getAge()>30);

    }

    public static void printFirstNameConditional(List<Person> pList, Predicate<Person> predicate) {
        for (Person p : pList) {
            if (predicate.test(p))
                System.out.println(p);
            
        }
    }
}
