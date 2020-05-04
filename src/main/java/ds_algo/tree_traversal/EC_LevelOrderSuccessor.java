package ds_algo.tree_traversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class EC_LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean matchFound = false;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                if (matchFound) return queue.peek();
                root = queue.poll();
                if (root.val == key) matchFound = true;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}

