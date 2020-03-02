package ds_algo.stacks_queues;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class LC346MovingAverage {

    private int queueSize;
    private Queue<Integer> queue;

    public LC346MovingAverage(int size) {
        queue = new LinkedList<>();
        queueSize = size;
    }

    public double next(int val) {
        if (queue.size() >= queueSize) {
            queue.poll();
        }
        queue.offer(val);
        double count = 0.0;
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            count += it.next();
        }
        return (count * 1.0) / queue.size();
    }
}




