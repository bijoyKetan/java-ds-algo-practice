package ds_algo.tree_traversal;

import org.junit.jupiter.api.Test;

public class TreeTraversal_Core {
    //In Order Traversal, l - n - r
    public void inOrderTraversal(TreeNode root) {
        //base case
        if (root == null) return;

        inOrderTraversal(root.left);
        processNode(root);
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        processNode(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        processNode(root);
    }

    private void processNode(TreeNode node) {
        System.out.print(node.val + "\t");
    }

    @Test
    void testTraversals() {
        TreeNode root = new TreeNode(9);
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

        preOrderTraversal(root);// 9 2 4 5 3 6
        System.out.println("\n");
        inOrderTraversal(root);// 4 2 5 9 6 3
        System.out.println("\n");
        postOrderTraversal(root);// 4 5 2 6 3 9
    }
}
