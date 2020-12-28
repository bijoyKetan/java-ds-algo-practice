package ds_algo.tree_traversal;

import org.junit.jupiter.api.Test;

public class Core_LC_Tree {

    private TreeNode root;

    public Core_LC_Tree() {
        this.root = new TreeNode(9);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        /*

              9
            /   \
           2     3
          / \   /
         4   5  6

         */

        root.left = n2;
        root.right = n3;
        root.left.left = n4;
        root.left.right = n5;
        root.right.left = n6;
    }

    //******************//
    //Fid max depth of binary tree
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    //******************//
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    void testMaxDepth() {
        System.out.println(maxDepth(this.root));
    }
}
