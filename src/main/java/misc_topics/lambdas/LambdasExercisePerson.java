package misc_topics.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExercisePerson {
    public static void main(String[] args) {
        //1. Create a list of persons
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Paul", "Rudd", 32, "New York"),
                new Person("Bruce", "Willis", 50, "LA"),
                new Person("Hanna", "Montana", 20, "LA")
        ));

        //2. Sort list by last name
        List<Person> lastNameSortedPeopleList = people.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
        System.out.println("Sorted list by last name: " + lastNameSortedPeopleList.toString() + "\n");

        //3. Create a method that prints all items of the list
        people.stream().forEach(System.out::println);

        //4. Create method that prints the first name of everyone
        people.stream().forEach(p -> System.out.println(p.getFirstName()));

        //5. Create a method that prints all people with last name beginning with c
        people.stream().forEach(p-> {
            if (p.getLastName().toLowerCase().startsWith("m")){
                System.out.println("\nFirst name starts with p: " + p);
            }
        });
    }
}
