package ds_algo.tree_traversal;

import java.util.Stack;

//find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
//https://www.educative.io/courses/grokking-the-coding-interview/RMlGwgpoKKY
public class EC_TreePathSum {
    public static boolean hasPathRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val; // each node from the sum's pov represents the diff w.r.t target
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathRecursive(root.left, sum) || hasPathRecursive(root.right, sum);
    }

    public static boolean hasPathIterative(TreeNode root, int sum) {
        if (root == null) return false;
        //Need to maintain two stacks to be able to trace the distinct paths from root to leaves
        //Pre order traversal
        Stack<TreeNode> stackNode = new Stack<>();
        stackNode.push(root);
        Stack<Integer> stackSum = new Stack<>();
        stackSum.push(sum - root.val); //stackSum represents the diff from w.r.t target

        while (!stackNode.isEmpty()) {
            root = stackNode.pop();
            sum = stackSum.pop();
            if (root.left == null && root.right == null && sum == 0) return true;
            if (root.right != null) {
                stackNode.push(root.right);
                stackSum.push(sum - root.right.val);
            }
            if (root.left != null) {
                stackNode.push(root.left);
                stackSum.push(sum - root.left.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path (recursive): " + hasPathRecursive(root, 23));
        System.out.println("Tree has path (recursive): " + hasPathRecursive(root, 16));
        System.out.println("Tree has path (iterative): " + hasPathIterative(root, 23));
        System.out.println("Tree has path (iterative): " + hasPathIterative(root, 16));

    }
}
