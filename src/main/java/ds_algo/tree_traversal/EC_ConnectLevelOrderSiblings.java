package ds_algo.tree_traversal;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    TreeNode2(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode2 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode2 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

class EC_ConnectLevelOrderSiblings {
    public static void connect(TreeNode2 root) {
        // TODO: Write your code here
        if (root == null) return;
        Deque<TreeNode2> queue = new ArrayDeque<>();
        queue.offer(root);
        //TreeNode2 previousNode = null;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                //base case - root.next -> queue.peek()
                //Once root is polled, queue.peek() is the next item
                //if the last item (i = queue.size -1) then root.next -> null
                root = queue.poll();
                if (i == queueSize - 1) root.next = null;
                else root.next = queue.peek();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        EC_ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
