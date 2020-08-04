package core;

import org.junit.jupiter.api.Test;

import java.util.*;

public class StackNQueue {

    @Test
    public void testStackQueue() {
        //Queue
        Deque<String> stack = new ArrayDeque<>();
        stack.push("sv1"); //void
        stack.push("sv2");
        stack.push("sv3");
        stack.peek(); //sv3. Return the last item
        stack.pop(); //sv3. Also removes v2 from stack.
        stack.size(); // 2, since sv3 popped
        stack.isEmpty(); // false
        Arrays.toString(stack.toArray()); //[sv2, sv1]
        stack.clear(); //removes all items
        stack.isEmpty(); //true

        //Stack
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("qv1"); //true, returns boolean
        queue.offer("qv2");
        queue.offer("qv3");
        queue.peek(); // qv1. Doesn't remove anything
        queue.poll(); // qv1. Removes qv1 from the queue
        queue.size(); // 2
        queue.isEmpty();//false
        queue.clear(); //removes all items
        queue.isEmpty();// true

        //Other available methods, not to be used for stack/queue
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("d1"); //void
        deque.addLast("d2"); //void
        deque.getFirst(); //d1
        deque.getLast(); //d2
        deque.removeFirst(); //d1
        deque.removeLast(); //d2
        deque.contains("d2"); //false
    }

    public static void main(String[] args) {
        //Stack DS creation
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");

        //Get the topmost element without changing data structure
        String stackHead = stack.peek();

        //Remove the top element
        String topElementRemoved = stack.pop();

        //Push on the top of the stack
        stack.push("E");

        //Size of stack
        int stackSize = stack.size();

        //----------Queue----------//
        Queue<String> queue = new LinkedList<>();

        //Enqueue
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");

        //Dequeue
        queue.poll();

        //Peek
        String queueHead = queue.peek();

        //queue size
        int queueSize = queue.size();

        //Print results
        System.out.println("---STACKS---");
        System.out.println("stack: " + stack);
        System.out.println("TopElement: " + stackHead);
        System.out.println("Stack size: " + stackSize + "\n");

        System.out.println("---QUEUES---");
        System.out.println("queue: " + queue);
        System.out.println("queue head: " + queueHead);
        System.out.println("queue size: " + queueSize);
    }
}
