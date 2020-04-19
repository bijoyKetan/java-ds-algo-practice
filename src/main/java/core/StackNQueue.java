package core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackNQueue {

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
