package core;

import java.util.*;

/*
Basic facts:
- Based on Array
- Dynamic resizing: When a list needs to be grown, all the elements are copied automatically to another bigger list.
- Retrieval and insertion -> O(1)
- Lists cannot contain primitives (so no int, but Integer).
- list.add() vs list.add(index, element) vs list.set (index, element)
 */

//add('A’), add(2,3.14), addAll(C), addAll(8,C), clearO, contains(2.71), get(12),
// index0f(289), isEmptyO, iteratorO, listlteratorO, remove(l), removeAll(C),
// retainAll(C), set(3,42), subListfl , 5), and toArrayO

public class ListCore {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Asia", "Europe", "Australia"));
        List<String> list2 = new ArrayList(Arrays.asList("USA", "Canada", "Mexico"));
        List<String> immutableList = Arrays.asList("Sam", "Ben", "Adam"); //Can't be modified

        list.add("Antarctica"); //add
        list.add(0, "Africaaa"); //add at an index
        list.set(0, "Africa"); //Update -> [Africa, Asia, Europe, Australia, Antarctica]
        list.addAll(list2); //[Africa, Asia, Europe, Australia, Antarctica, USA, Canada, Mexico]

        list.indexOf("USA"); //5
        list.indexOf("TATA"); //-1, doesn't exist
        list.lastIndexOf("Mexico"); // 7, for multiple results, last index

        list.remove("Asia"); // [Africa, Europe, Australia, Antarctica, USA, Canada, Mexico]
        list.remove(0); // [Europe, Australia, Antarctica, USA, Canada, Mexico]
        list.removeAll(list2); // [Europe, Australia, Antarctica]

        list2.isEmpty(); //false
        list2.clear(); //Removes all elements and makes it empty
        list2.isEmpty(); // true

        //collection.iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //do something with each element
            String item = iterator.next();
            System.out.println(item);
        }

        List<String> list3 = new ArrayList(Arrays.asList("NYC", "Cairo", "Moscow", "NYC", "LA"));
        Set<String> set = new HashSet<>(list3); //Removes duplicates
        //Cairo, LA, NYC, Moscow]

        //List of start and end times
        //Sort by end times and then by start times
        List<int[]> intervals = new ArrayList<>(Arrays.asList(new int[][]{{7, 9}, {4, 9}, {5, 8}}));
        intervals.sort((e1, e2) -> {
            if (e1[1] != e2[1]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        }); // [5,8], [4,9], [7,9]

        //Sorting by multiple conditions
        //First by the last elements, then by the second elements and then by the first elements
        List<int[]> intervals2 = new ArrayList<>(Arrays.asList(new int[][]{{7, 9, 10}, {4, 9, 11}, {3, 9, 11}}));
        intervals2.sort((e1, e2) -> {
            if (e1[2] != e2[2]) return e1[2] - e2[2];
            else if (e1[1] != e2[1]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        }); //[7, 9, 10], [3, 9, 11], [4, 9, 11]
    }
}
