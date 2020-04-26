package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static core.DepthFirstSearch.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DepthFirstSearch {

    //Var needs to be outside method. Otherwise would get reinitialized each time.
    public static List<Integer> result = new ArrayList<>();


    public static List<Integer> inOrderTraversalRecursive(TreeNode currentNode) {
        //Implicitly the call stack is used here for LIFO.
        //left - node - right
        if (currentNode != null) {
            inOrderTraversalRecursive(currentNode.left);
            result.add(currentNode.val);
            inOrderTraversalRecursive(currentNode.right);
        }
        return result;
    }

    public static List<Integer> preOrderTraversalRecursive(TreeNode currentNode) {
        if (currentNode != null) {
            //node - left - right
            result.add(currentNode.val);
            preOrderTraversalRecursive(currentNode.left);
            preOrderTraversalRecursive(currentNode.right);
        }
        return result;
    }

    public static List<Integer> postOrderTraversalRecursive(TreeNode currentNode) {
        if (currentNode != null) {
            //left - right - node
            postOrderTraversalRecursive(currentNode.left);
            postOrderTraversalRecursive(currentNode.right);
            result.add(currentNode.val);
        }
        return result;
    }

    //--------ITERATIVE APPROACH WITH EXPLICIT STACK--------//

    public static List<Integer> preOrderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return result;
    }

    public static List<Integer> postOrderTraversalIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            result.addFirst(root.val); //adding in a reverse order
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return result;
    }

    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}


class TestDepthFirstTraversals {

    TreeNode root;

    @BeforeEach
    public void setUp() {
        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
    }

    @AfterEach
    public void tearDown() {
        root = null;
    }

    //Conduct one test at a time sine result array is shared (see the DepthFirstSearch class for details)
    @Test
    public void testPostOrderRecursive() {
        assertThat(postOrderTraversalRecursive(root)).isEqualTo(Arrays.asList(9, 7, 10, 5, 1, 12));
    }

    @Test
    public void testInOrderTraversalIterative() {
        assertThat(inOrderTraversalIterative(root)).isEqualTo(inOrderTraversalRecursive(root));
    }

    @Test
    public void testPreOrderTraversalIterative() {
        assertThat(preOrderTraversalIterative(root)).isEqualTo(preOrderTraversalRecursive(root));
        assertThat(preOrderTraversalIterative(root)).isEqualTo(Arrays.asList(12, 7, 9, 1, 10, 5));
    }

    @Test
    public void testPostOrderTraversalIterative() {
        assertThat(postOrderTraversalRecursive(root)).isEqualTo(postOrderTraversalIterative(root));
    }
}
