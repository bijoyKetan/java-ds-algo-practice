package core;

import java.util.Stack;

public class StackNQueue {

    public static void main(String[] args) {
        //Stack DS creation
        Stack<String> stack = new Stack<>();
        stack.add("A");
        stack.add("B");
        stack.add("C");
        stack.add("D");
        stack.add("E");

        //Get the topmost element
        String topElement = stack.peek();

        //Remove the top element
        String topElementRemoved = stack.pop();

        //Push on the top of the stack
        stack.push("E");

        //Size of stack
        int stackSize = stack.size();

        //Print results
        System.out.println("stack: " + stack + "\n");
        System.out.println("TopElement: " + topElement + "\n");
        System.out.println("Stack size: " + stackSize + "\n");

    }
}
