package ds_algo.tree_traversal;

import org.junit.jupiter.api.Test;

public class Core_LC_Tree {

    private TreeNode root1;
    private TreeNode root2;
    private TreeNode root3;

    public Core_LC_Tree() {
        this.root1 = new TreeNode(9);
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

        root1.left = n2;
        root1.right = n3;
        root1.left.left = n4;
        root1.left.right = n5;
        root1.right.left = n6;

        root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(3);
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
        System.out.println(maxDepth(this.root1));
    }

    //******************//
    //Symmetric tree from the center
    //https://leetcode.com/problems/symmetric-tree/
    //******************//

    public boolean isSymmetric(TreeNode root) {
        //For symmetry, we're comparin  g two trees
        return helperSymmetry(root, root);
    }

    private boolean helperSymmetry(TreeNode n1, TreeNode n2) {
        //if both nodes null, then symmetric
        if (n1 == null && n2 == null) return true;
            //if only one node null, asymmetric
        else if (n1 == null || n2 == null) return false;
        return (n1.val == n2.val) &&
                helperSymmetry(n1.left, n2.right) &&
                helperSymmetry(n1.right, n2.left);
        /*
        Following is incorrect:
        How are we using the return booleans ?
        return statement throws null pointer exceptions
        for leaf nodes or nodes with only one child
         */

        /*
        helperSymmetry(n1.left, n2.right);
        helperSymmetry(n1.right, n2.left);
        return (n1.val == n2.val) &&
             (n1.right.val == n2.left.val) &&
             (n1.left.val == n2.right.val);
         */
    }

    @Test
    void testSymmetry() {
        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetric(root2));
        System.out.println(isSymmetric(root3));
    }


    //******************//
    //Path Sum
    //https://leetcode.com/problems/path-sum/
    //******************//
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helperPathSum(root, sum, 0);
    }

    private boolean helperPathSum(TreeNode root, int sum, int currSum) {
        //Root == null could be from any parent and not just from leaf parent
        if (root == null) return false;
        //Update the result var
        currSum += root.val;
        //Ensures left node and then checks sum
        if (root.left == null && root.right == null) {
            return sum == currSum;
        }
        return helperPathSum(root.left, sum, currSum) ||
                helperPathSum(root.right, sum, currSum);
    }

    public boolean hasPathSumDirect(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSumDirect(root.left, sum) ||
                hasPathSumDirect(root.right, sum);

    }

    @Test
    void testPathSUm() {
        System.out.println(hasPathSum(root1, 18));
        System.out.println(hasPathSum(root2, 99));
        System.out.println(hasPathSum(root3, 1));

        System.out.println(hasPathSumDirect(root1, 18));
        System.out.println(hasPathSumDirect(root2, 99));
        System.out.println(hasPathSumDirect(root3, 1));
    }

    //******************//
    //250. Count Univalue Subtrees
    //https://leetcode.com/problems/count-univalue-subtrees/
    //******************//
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    // boolean n-> track if a tree is univalSubtree
    // no need to track this as a parameter
    //int[] since just int will be passed by value
    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }

        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);

        if (left && right) {
            //Reduces the possibilities
            //The other condition (success condition) has more flows
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
