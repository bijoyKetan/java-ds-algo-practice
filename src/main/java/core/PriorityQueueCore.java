package core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueCore {
    public static void main(String[] args) {

        // *** CORE METHODS *** //
        PriorityQueue<String> minHeap =
                new PriorityQueue<>(5, (s1, s2) -> s1.length() - s2.length());
        minHeap.offer("Tom");
        //pq.add(""); // -> performs the same func
        //add vs offer -> collection vs queue interfaces
        minHeap.offer("Cathy");
        minHeap.offer("Robert");
        minHeap.offer("Bo");
        minHeap.size(); //4
        //[Bo, Tom, Robert, Cathy]

        minHeap.peek(); //Bo
        minHeap.poll(); //Bo
        // Post polling ->  Tom, Cathy, Robert
        minHeap.isEmpty();

        // *** PQ WITH MAP *** //
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 21);
        map.put("Jon", 41);
        map.put("Ben", 31);
        map.put("Ron", 33);

        //Key set is enough.
        //Descending sort by values
        PriorityQueue<String> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        //Polling from PQ -> sorted order removal
        while (!pq.isEmpty()) {
            //Don't poll multiple times in same loop
            String name = pq.poll();
            System.out.println(name + " " + map.get(name));
        }

        /*
        NOTE: poll() from pq restored the heap property
        forEach doesn't retain heap property
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getKey());
        }
         */
    }


    //Classic use case - Merge K sorted arrays
    //Additional difficulty with arrays than with lists/linkedLists
    public int[] mergeKSortedArrays(int[][] nums) {
        //PQ will contain a custom DS represented by wrapper class ArrayContainer
        //Custom DS has compareTo method, so no need for lambda with comparator
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();

        //Populate the pq, initializing the tracker pointer at 0
        int totalLength = 0; //length of merged 1D array from K inner arrays;
        for (int[] arr : nums) {
            pq.offer(new ArrayContainer(arr, 0));
            totalLength += arr.length;
        }
        //Initialize the result array with the derived size
        int[] mergedArray = new int[totalLength];

        int mergedIndex = 0;
        while (!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            //Adding to the merged list and incrementer index pointer
            mergedArray[mergedIndex++] = ac.array[ac.index++];
            //ac.index++; -> The above shorthand makes this unnecessary
            if (ac.index < ac.array.length) {
                pq.offer(ac);
            }
        }
        return mergedArray;
    }


    //Private wrapper class to contain the custom data structure in priority Queue
    //Implements compareTo for use with lambda with Comparator
    class ArrayContainer implements Comparable<ArrayContainer> {
        int[] array; // The inner array
        int index; // The index of the inner array

        public ArrayContainer(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer other) {
            return this.array[this.index] - other.array[other.index];
        }
    }

    @Test
    public void testMergeKSorted() {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2, 5, 8};
        int[] arr3 = new int[]{3, 6, 9};
        int[][] arr = new int[][]{arr2, arr1, arr3};
        System.out.println(Arrays.toString(mergeKSortedArrays(arr)));
    }
}

