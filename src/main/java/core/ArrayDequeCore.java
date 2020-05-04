package core;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeCore {

    public static void main(String[] args) {

        //***********//
        //   STACK   //
        //***********//
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //-> [5, 4, 3, 2, 1]

        int headItem = stack.peek(); // -> 5
        int headItemRemoved = stack.pop(); // -> 5

        //***********//
        //   QUEUE   //
        //***********//
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        //-> [1, 2, 3, 4, 5]

        int queueHead = queue.peek(); //-> 1
        int queueHeadRemoved = queue.poll(); // -> 1
        // -> [2, 3, 4, 5]

        int firstItem = queue.getFirst(); // -> 2
        int lastItem = queue.getLast(); // -> 5
        int lastRemoved = queue.removeLast(); // -> 5


        // PRINT RESULTS
        System.out.println("Stack: " + stack.toString());
        System.out.println("Head item from peek: " + headItem);
        System.out.println("Head item removed/popped: " + headItemRemoved);
        System.out.println("Queue: " + queue.toString());
        System.out.println("Queue head item from peek: " + queueHead);
        System.out.println("Queue head removed/polled: " + queueHeadRemoved);
        System.out.println(queue);
        System.out.println(firstItem);
        System.out.println(lastItem);
        System.out.println(lastRemoved);
    }
}
