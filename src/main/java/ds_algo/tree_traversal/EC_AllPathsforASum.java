package ds_algo.tree_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class EC_AllPathsforASum {
    public static List<List<Integer>> findPathsIterative(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        LinkedList<Integer> innerList;
        if (root == null) return allPaths;
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stackNode.push(root);
        stackSum.push(sum - root.val);

        while (!stackNode.isEmpty()) {
            root = stackNode.pop();
            sum = stackSum.pop();

            if (root.right == null && root.left == null && sum == 0) {
                innerList = new LinkedList<>();
                for (int i = 0; i < stackNode.size(); i++) {
                    innerList.addFirst(stackNode.elementAt(i).val);
                }
                allPaths.add(innerList);
            }

            if (root.right != null) {
                stackNode.push(root.right);
                stackSum.push(sum - root.right.val);
            }

            if (root.left != null) {
                stackNode.push(root.left);
                stackSum.push(sum - root.left.val);
            }

        }

        return allPaths;
    }

//    public static List<List<Integer>> findPathsRecursive(TreeNode root) {
//        List<List<Integer>> allPaths = new ArrayList<>();
//        List<Integer> innerList = new ArrayList<>();
//
//        if (root == null) return allPaths;
//
//    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPathsIterative(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}


