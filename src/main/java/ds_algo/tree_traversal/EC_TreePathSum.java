package ds_algo.tree_traversal;

public class EC_TreePathSum {
    public static boolean hasPathRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathRecursive(root.left, sum - root.val) || hasPathRecursive(root.right, sum - root.val);
    }

    public static boolean hasPathIterative(TreeNode root, int sum) {
        return false;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPathRecursive(root, 23));
        System.out.println("Tree has path: " + hasPathRecursive(root, 16));
    }
}
