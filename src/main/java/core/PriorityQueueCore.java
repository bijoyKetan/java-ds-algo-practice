package core;

import java.util.PriorityQueue;

public class PriorityQueueCore {
    public static void main(String[] args) {

        PriorityQueue<String> minHeap = new PriorityQueue<>(5, (s1, s2) -> s1.length() - s2.length());
        minHeap.offer("Tom");
        minHeap.offer("Cathy");
        minHeap.offer("Robert");
        minHeap.offer("Bo");
        minHeap.size(); //4
        //[Bo, Tom, Robert, Cathy]

        minHeap.peek(); //Bo
        minHeap.poll(); //Bo
        // Post polling ->  Tom, Cathy, Robert
    }
}
