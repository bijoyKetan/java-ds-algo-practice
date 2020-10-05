package core;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TipsTricks {

    @Test
    public void iteratorExample() {
        //Set ups
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(9);

        //Iterate over a collection
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            var a = it.next();
            System.out.println("Queue item: " + a);
        }

        Map<String, String> map = new HashMap<>();
        map.put("Name", "Kyle");
        map.put("Location", "NY");
        map.put("Car", "Toyota");
        //Iterate over a map with iterator
        for (Map.Entry<String, String> e : map.entrySet()) {
            var key = e.getKey();
            var value = e.getValue();
            System.out.format("%s : %s\n", key, value);
        }
    }


    @Test
    public void ifElseExample() {
        //CASE 1 - Multiple if: each condition is checked independently
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            if (i < 6) System.out.printf(" %s < 6, \t", i);
            if (i < 7) System.out.printf(" %s < 7, \t", i);
            if (i < 8) System.out.printf(" %s < 8, \t", i);
            System.out.println(" Final statement");
        }
        //CASE 1 RESULT
        /*
         0 < 5, 	 0 < 6, 	 0 < 7, 	 0 < 8, 	 Final statement
         2 < 5, 	 2 < 6, 	 2 < 7, 	 2 < 8, 	 Final statement
         4 < 5, 	 4 < 6, 	 4 < 7, 	 4 < 8, 	 Final statement
         6 < 7, 	 6 < 8, 	 Final statement
        Final statement
        */

        System.out.println("\n\n");

        //CASE 2 - if + else if: each else if is dependent on the previous if/ else if condition
        //and will be executed only if the previous checks are not satisfied
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            else if (i < 6) System.out.printf(" %s < 6, \t", i);
            else if (i < 7) System.out.printf(" %s < 7, \t", i);
            else if (i < 8) System.out.printf(" %s < 8, \t", i);
            else System.out.println(" Final statement");
        }
        //CASE 2 RESULT
        //  0 < 5, 	 2 < 5, 	 4 < 5, 	 6 < 7, 	 Final statement
    }

    @Test
    public void miscTricks() {
        int a = 10, b = 20;
        System.out.println(String.format("A is %s, and B is %s", a, b));
    }

    @Test
    public void orderOfExecution() {
        int[] arr = new int[]{1, 2, 3, 4};

        int i = 0;
        while (i < arr.length) {
            //if (i < arr.length - 1 && i % 2 == 0) {
            if (i % 2 == 0 && i < arr.length - 1) {
                var num = arr[i + 1];
                System.out.println(num);
                i++;
            } else {
                i++;
            }
        }
    }
}
