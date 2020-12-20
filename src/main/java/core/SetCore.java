package core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetCore {
    // Collection that cannot contain duplicate elements.
    // It models the mathematical set abstraction.
    // add(), remove() and contains() operations cost constant O(1) time.
    // Due to the internal HashMap implementation.

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        set.add(4);
        set.remove(4);
        set.size();//size of set
        set.isEmpty(); //boolean
        set.addAll(Arrays.asList(4, 5, 6, 6));

        set.contains(4); //true
        set.iterator().next();//first item of set

        //Iterating through set items
        for (int i : set) {
            System.out.println(i);
        }

        //Same as the one above
        //common error: set.forEach(x -> x * 2);
        set.forEach(System.out::println);

        set.toArray(); //[1, 2, 3, 5, 6, 10]
    }
}
