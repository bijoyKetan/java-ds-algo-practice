package ds_algo.tree_traversal;

public class EC_PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        //DFS
        //at each level compare the node val with seq val
        //if not equal then false
        //if at the leaf and the values are equal, then true

        if (root == null) return (sequence.length == 0);
        int level = 0;
        return helper(root, sequence, level);
    }

    private static boolean helper(TreeNode root, int[] sequence, int level) {
        if (root == null) return false;
        //if (root.val != sequence[level]) return false; //This is not entirely right...what if sequence is too small?
        if (level >= sequence.length || root.val != sequence[level]) return false;
        if (root.right == null && root.left == null && sequence[level] == root.val && sequence.length == level + 1)
            return true;
        level++;
        //This part is critical. OR condition since any one success is good enough.
        return (helper(root.right, sequence, level) || helper(root.left, sequence, level));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + findPath(root, new int[]{1}));
        System.out.println("Tree has path sequence: " + findPath(root, new int[]{1, 1, 6}));
    }
}



