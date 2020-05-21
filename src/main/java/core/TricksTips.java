package core;

import java.util.*;

public class TricksTips {
    public static void main(String[] args) {
        //Set ups
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(9);

        Map<String, String> map = new HashMap<>();
        map.put("Name", "Kyle");
        map.put("Location", "NY");
        map.put("Car", "Toyota");

        //Iterate over a collection
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println("Queue item: " + it.next());
        }

        //Iterate over a map
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.format("%s : %s\n", e.getKey(), e.getValue());
        }

        //Declare multiple variables in the same line
        int a = 10, b = 20;

        //If else differences
        testIfElse(); //
        //testIfElse2();
    }

    //If else execution differences
    public static void testIfElse() {
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            if (i < 6) System.out.printf(" %s < 6, \t", i);
            if (i < 7) System.out.printf(" %s < 7, \t", i);
            if (i < 8) System.out.printf(" %s < 8, \t", i);
            System.out.println(" Final statement");
        }
    }

    public static void testIfElse2() {
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            else if (i < 6) System.out.printf(" %s < 6, \t", i);
            else if (i < 7) System.out.printf(" %s < 7, \t", i);
            else if (i < 8) System.out.printf(" %s < 8, \t", i);
            else System.out.println(" Final statement");
        }
    }
}
