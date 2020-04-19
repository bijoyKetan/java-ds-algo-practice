package core;

import java.util.*;

public class UsefulCodeBlocks {
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


    }
}
