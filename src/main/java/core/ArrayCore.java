package core;

import java.util.Arrays;

public class ArrayCore {

    public static void main(String[] args) {

        //Iterate through the list and print all elements
        //Remove certain items from DS
        //Is DS empty


        //Create the DS
        String[] myArray = new String[]{"Asia","Europe","Africa","America","Australia"};
        System.out.println("Array1 is -> " + Arrays.toString(myArray));

        String[] yourArray = new String[5];
        yourArray[0] = "Africa";
        yourArray[1] = "Asia";
        yourArray[2] = "North America";
        yourArray[3] = "Australia";
        yourArray[4] = "Europe";
        System.out.println("Array 2 is -> " + Arrays.toString(yourArray));

        //Access first and last item
        String firstItem = myArray[0];
        String lastItem = myArray[myArray.length-1];
        System.out.println("The first item is: -> " + firstItem + "\nThe last item is -> " + lastItem);

        //Access an item by value


    }
}
