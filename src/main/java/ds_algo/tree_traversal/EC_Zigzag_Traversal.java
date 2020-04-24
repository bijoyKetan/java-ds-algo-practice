package ds_algo.tree_traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Zigzag traversal...left to right and the right to left and so on
// level order traversal

//Pseudo code:
//    1. A variable that represents the state for traversal direction
//    2. Add the node to queue.
//    3. Deque until queue is empty and for each item do the following:
//    3. If dequeued node is even then right -> left for the children nodes.
//    4. If dequeued node is odd then left -> right for the children nodes.

//Notes:
//1. Use boolean instead of int =1 and then checking for odd/even and incrementing by 1
//2. For the level order traversal, becaus eof non lineardata struct, need to add to queue in a consistent direction. left -> Right
//3. Use a linked list for when you need to add items in a LIFO order LinkedList.add(0, item);

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode currentNode = queue.poll();
                if (leftToRight) levelList.add(currentNode.val);
                else levelList.add(0, currentNode.val);

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            leftToRight = !leftToRight;
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}



