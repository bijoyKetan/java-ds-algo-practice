package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
Basic facts:
- Based on Array
- Dynamic resizing: When a list needs to be grown, all the elements are copied automatically to another bigger list.
- Retrieval and insertion -> O(1)
- Lists cannot contain primitives (so no int, but Integer).
 */

public class ListCore {
    public static void main(String[] args) {

        //Create the DS
        List<String> myList = new ArrayList<>();

        //Add items to list & print the result
        myList.add("Africa");
        myList.add("Asia");
        myList.add("North America");
        myList.add("Europe");
        myList.add("Antarctica");
        myList.add("Australia");
        myList.add("South America");
        System.out.println("myList is ->  " + myList);
        System.out.println("The datatype is " + myList.getClass().getSimpleName());


        //Create the same DS in a different way - note this creates an immutable list
        List<String> yourList = Arrays.asList("Sam", "Ben", "Adam", "Matt", "Nick");
        System.out.println("Second List is" + yourList);

        //To make the above list mutable

        //Access first and last item
        String firstElement = myList.get(0);
        String lastElement = myList.get(myList.size() - 1);
        System.out.println("The first element is -> " + firstElement +
                "\nThe last element is -> " + lastElement);

        //Access an item by value
        int isAfrica = myList.indexOf("Africa");
        int isRand = myList.indexOf("Rand");
        System.out.println("isRand present ->  " + isRand);

        //Iterate through the list and print all elements
        for (String cont : myList) System.out.println("Index: " + myList.indexOf(cont) + " value: " + cont);

        //Remove certain items from DS
        myList.removeAll(myList.subList(1, 4));
        System.out.println(myList);

        //Is DS empty
        //boolean isEmp = myList.isEmpty();
        System.out.println(myList.isEmpty());

    }
}
