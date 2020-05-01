package ds_algo.tree_traversal;

import java.util.ArrayList;
import java.util.List;

public class EC_SumOfPathNumbers {
    public static int sumNumbers(TreeNode root) {
        StringBuilder numBuilder = new StringBuilder();
        List<Integer> numList = new ArrayList<>();
        helperFunc(numBuilder, numList, root);
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }

    private static void helperFunc(StringBuilder numBuilder, List<Integer> numList, TreeNode root) {
        if (root == null) return;

        //add node to string
        numBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            //convert string to number
            int val = Integer.parseInt(numBuilder.toString());
            //add number to numberList
            numList.add(val);
        }

        helperFunc(numBuilder, numList, root.left);
        helperFunc(numBuilder, numList, root.right);
        //backtracking and removing the last node
        numBuilder.deleteCharAt(numBuilder.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + sumNumbers(root));
    }

}
