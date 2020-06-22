package core;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8 {

    public static void main(String[] args) {

        // Working with Optionals.
        //"Optional.of(x)" use this when x will not have any null values
        //"Optional.empty()" use this for creating an empty optional
        //"Optional.ofNullable(x)" use this when x may contain null values
        String a = "StrA";
        String b = "StrB";
        String c = null;
        var listOfOptionals = Arrays.asList(a, b, c);

        var transformedList = listOfOptionals
                .stream()
                .map(Optional::ofNullable)
                .map(x -> x.map(String::toUpperCase).orElse("EMPTY"))
                .collect(Collectors.toList());

        System.out.println("List of optionals: " + transformedList);

        //Flatmap
        var listA = Arrays.asList("a", "b", "c");
        var listB = Arrays.asList("w", "x", "y");
        var d = "d";
        var heterogeneousList = Arrays.asList(listA, listB);
        //var heterogeneousList = Arrays.asList(listA, listB, d); => This would not work as heterogeneousList would be a List<Object>
        System.out.println("Unflattened list: " + heterogeneousList);

        var homogeneousList = heterogeneousList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("Flattened list: " + homogeneousList);
    }
}
