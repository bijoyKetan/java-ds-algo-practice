package core;

import java.util.*;

public class TipsTricks {
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
        //testIfElse();
        //testIfElse2();

        //Order of execution in a conditional statement (if/while). Left to right
        //while (start < end && arr[start] == arr[start + 1])
        //NOT the same as while (arr[start] == arr[start + 1] && start < end )
        //Esp with indices (start+1) be careful to check when it gets out of bounds


    }

    //If else execution differences
    public static void testIfElse() { //executes all the statements that are satisfied by condition
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            if (i < 6) System.out.printf(" %s < 6, \t", i);
            if (i < 7) System.out.printf(" %s < 7, \t", i);
            if (i < 8) System.out.printf(" %s < 8, \t", i);
            System.out.println(" Final statement");
        }
    }
    //Result of testIfElse()
    /*
     0 < 5, 	 0 < 6, 	 0 < 7, 	 0 < 8, 	 Final statement
     2 < 5, 	 2 < 6, 	 2 < 7, 	 2 < 8, 	 Final statement
     4 < 5, 	 4 < 6, 	 4 < 7, 	 4 < 8, 	 Final statement
     6 < 7, 	 6 < 8, 	 Final statement
    Final statement
    */

    public static void testIfElse2() {//Executes only the first statement, from top to bottom, that is satisfied
        for (int i = 0; i < 10; i += 2) { //0, 2, 4, 6, 8
            if (i < 5) System.out.printf(" %s < 5, \t", i);
            else if (i < 6) System.out.printf(" %s < 6, \t", i);
            else if (i < 7) System.out.printf(" %s < 7, \t", i);
            else if (i < 8) System.out.printf(" %s < 8, \t", i);
            else System.out.println(" Final statement");
        }
    }
    // Result of testIfElse2()
    //  0 < 5, 	 2 < 5, 	 4 < 5, 	 6 < 7, 	 Final statement
}
