package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    //Var needs to be outside method. Otherwise would get reinitialized each time.
    public static List<Integer> result = new ArrayList<>();

    public static List<Integer> inOrderTraversal(TreeNode currentNode) {
        //Implicitly the call stack is used here for LIFO.
        //left - node - right
        if (currentNode != null) {
            inOrderTraversal(currentNode.left);
            result.add(currentNode.val);
            inOrderTraversal(currentNode.right);
        }
        return result;
    }

    public static List<Integer> preOrderTraversal(TreeNode currentNode) {
        if (currentNode != null) {
            //node - left - right
            result.add(currentNode.val);
            preOrderTraversal(currentNode.left);
            preOrderTraversal(currentNode.right);
        }
        return result;
    }

    public static List<Integer> postOrderTraversal(TreeNode currentNode) {
        if (currentNode != null) {
            //left - right - node
            postOrderTraversal(currentNode.left);
            postOrderTraversal(currentNode.right);
            result.add(currentNode.val);
        }
        return result;
    }

    //--------ITERATIVE APPROACH WITH EXPLICIT STACK--------//
    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        TreeNode currentNode = root;
        //Stack to hold the items
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || currentNode != null) {
            //Keep iterating until the last left element
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;//keep moving the pointer
            } //out of this loop means current node = null
            currentNode = stack.pop(); //resets the current pointer to non-null
            result.add(currentNode.val);
            currentNode = currentNode.right; // look for the right branch of the sub tree
        }
        return result;
    }


    public static void main(String[] args) {
        //https://www.educative.io/courses/grokking-the-coding-interview/RMlGwgpoKKY
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        //assertThat(postOrderTraversal(root)).isEqualTo(Arrays.asList(9, 7, 10, 5, 1, 12));
        System.out.println(inOrderTraversalIterative(root));
    }
}
