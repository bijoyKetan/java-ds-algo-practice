package ds_algo.tree_traversal;

import java.util.LinkedList;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO
public class EC_MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return -1;
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                root = queue.poll();
                if (root.right == null && root.left == null) return level;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
    }
}
