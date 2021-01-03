package ds_algo.tree_traversal;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    public void printTreePreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
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

    //******************//
    //1008. Construct Binary Search Tree from Preorder Traversal/
    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    //******************//

    //Input is guaranteed to be pre order traversal of a valid BST
    /*
       NOTE: In tree problems if counter/index required, do not use primitive
       use int[]/primitive[] since in java primitive params are passed by value
       i.e. the caller doesn't see the changes make by the other calls recursively before it.
     */

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helperBstFromPreorder(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE, new int[]{0});
    }

    private TreeNode helperBstFromPreorder(int[] preorder, int upper, int lower, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] < lower || preorder[index[0]] > upper) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[index[0]++]);
        treeNode.left = helperBstFromPreorder(preorder, treeNode.val, lower, index);
        treeNode.right = helperBstFromPreorder(preorder, upper, treeNode.val, index);

        return treeNode;
    }

    /*
    NOTE: Following does not work

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helperBstFromPreorder(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    private TreeNode helperBstFromPreorder(int[] preorder, int upper, int lower, int index) {
        if (index >= preorder.length || preorder[index] < lower || preorder[index] > upper) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[index++]);
        treeNode.left = helperBstFromPreorder(preorder, treeNode.val, lower, index);
        treeNode.right = helperBstFromPreorder(preorder, upper, treeNode.val, index);

        return treeNode;
    }
     */


    //******************//
    //106. Construct Binary Tree from Inorder and Postorder Traversal
    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    //******************//

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        //Map <value, index> from inOrder traversal to
        //track index for left and right subtree bounds
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helperInPostTree(inorder, postorder, 0, postorder.length - 1, new int[]{postorder.length - 1}, map);
    }

    //Left and right bounds here absolute for each caller so int/immutable
    //postIndex needs to change state globally for other callers -> so Object
    //There's only one postIndex globally whereas each recursive call has their own left/right bounds
    //Map is also global, as are inOrder and postOrder, but these are not changing in this function
    private TreeNode helperInPostTree(int[] inorder, int[] postorder, int leftIndex, int rightIndex, int[] postIndex, Map<Integer, Integer> map) {
        if (leftIndex > rightIndex) {
            //Empty subtree
            return null;
        }
        //Create tree from postOrder traversal
        TreeNode treeNode = new TreeNode(postorder[postIndex[0]--]);

        //Get
        int index = map.get(treeNode.val);
        treeNode.right = helperInPostTree(inorder, postorder, index + 1, rightIndex, postIndex, map);
        treeNode.left = helperInPostTree(inorder, postorder, leftIndex, index - 1, postIndex, map);

        return treeNode;

    }


    /*
    Pass by value and ref demo
     */
    public int recursionState(int[] arr, int num) {
        if (num >= arr.length - 1) return arr[arr.length - 1];
        arr[arr.length - 1] += arr[num++] * 2;
        System.out.println(num);
        int a = recursionState(arr, num);
        num += 1;
        System.out.println(num);
        return a + recursionState(arr, num);
    }

    public int recursionState2(int[] arr, int[] num) {
        if (num[0] >= arr.length - 1) return arr[arr.length - 1];
        arr[arr.length - 1] += arr[num[0]++] * 2;
        //System.out.println(arr[arr.length - 1]);
        System.out.println(num[0]);
        int a = recursionState2(arr, num);
        num[0] += 1;
        System.out.println(num[0]);
        return a + recursionState2(arr, num);
    }

    @Test
    void testRecursionStates() {
        System.out.println("Result from primitive is: " + recursionState(new int[]{1, 2, 3, 0}, 0));
        System.out.println("Result from object  is: " + recursionState2(new int[]{1, 2, 3, 0}, new int[]{0}));
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //Do I have all the info/states I need in the params?
        //If yes, I may not need a separate helper function
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode merged = new TreeNode(t1.val + t2.val);

        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

    }

    @Test
    void testMergedTrees() {
        printTreePreOrder(mergeTrees(root1, root2));
    }

    //******************//
    //110. Balanced Binary Tree
    //https://leetcode.com/problems/balanced-binary-tree/
    //******************//

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helperBalanced(root) != -1;
    }

    private int helperBalanced(TreeNode node) {
        //base case
        if (node == null) return 0;

        //Post order traversal is efficient here
        //Get height of left and right subtree
        int left = helperBalanced(node.left);
        int right = helperBalanced(node.right);

        //if left subtree is -1, then not balanced
        if (left == -1 || right == -1) return -1;
        //if right subtree is -1, then not balanced
        if (Math.abs(left - right) > 1) return -1;

        //Finally process node - i.e. height of node
        //max depth between left and right subtree
        return Math.max(left, right) + 1;
    }


    //******************//
    //98. Validate Binary Search Tree
    //https://leetcode.com/problems/validate-binary-search-tree/
    //******************//

    /*
   Check values left < node < right
   Check that both left subtree and right subtree are BST
   Given root : Need to check with max - min range
   Ensure all node values fall inrange
   Bottom up post order traversal
   */
    public boolean isValidBST(TreeNode root) {
        return helperValidator(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    /*
    This method is more efficient as it fails fast
    Insted of using AND condiion that forces the check of both subtrees,
    Using OR condition that fails as soon as one of the subtrees fail
    */
    private boolean helperValidator(TreeNode root, double min, double max){
        if (root == null) return true;

        //process left and right children recursively
        boolean isLeft = helperValidator (root.left, min, root.val);
        boolean isRight = helperValidator (root.right, root.val, max);
        if (!isLeft || !isRight) return false;


        //process node
        if (root.val <= min || root.val >= max) return false;
        return true;
    }

    /*
        private boolean helperValidator(TreeNode root, double min, double max){
        if (root == null) return true;

        //process left and right children recursively
        boolean isLeft = helperValidator (root.left, min, root.val);
        boolean isRight = helperValidator (root.right, root.val, max);

        //process node
        return isLeft && isRight && root.val < max && root.val > min;
    }
    */



}
