package core;

import java.sql.SQLOutput;
import java.util.Arrays;

/*
String [] myArray = {"val1", "val2", "val3"};
myArray.length;
firstItem  = myArray[1];
lastItem = myArray[myArray.length -1];
for (String i:myArray) {expression};
for (int i = 0; i < myArray.length; i++) {expression};
*/

public class ArrayCore {

    public static void main(String[] args) {

        System.out.print("");
        System.out.println("");
        //Create the DS
        String[] myArray = {"Asia", "Europe", "Africa", "America", "Australia"};
        System.out.println("Array1 is -> " + Arrays.toString(myArray));

        String[] myArray4 = new String[]{"val1", "val2", "val3"};
        String[] myArray6 = new String[]{"val1", "val2", "val3"};

        String[] yourArray = new String[5];
        yourArray[0] = "Africa";
        yourArray[1] = "Asia";
        yourArray[2] = "North America";
        yourArray[3] = "Australia";
        yourArray[4] = "Europe";
        System.out.println("Array 2 is -> " + Arrays.toString(yourArray));

        //Access first and last item
        String firstItem = myArray[0];
        String lastItem = myArray[myArray.length - 1];
        System.out.println("The first item is: -> " + firstItem + "\nThe last item is -> " + lastItem);

        //Array Copy
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        System.arraycopy(arr1, 2, arr2, 2, 3); //-> [6,7,3,4,5]
        System.out.println(Arrays.toString(arr2));
    }
}
