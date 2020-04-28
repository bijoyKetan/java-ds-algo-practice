package core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;


//Create a node class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

//Class to conduct BFS - print the items of each level as a list
public class BreadthFirstSearch {
    //Create a queue to hold the nodes
    //Check if the root is null. If not null, add the root
    //Do the following until queue is empty (while !queue.isEmpty())
    //Get queue size. Iterate ove that queueSize -> represents the level size
    //Poll from queue and point root to that. Add root to levelList
    //Add the left and right children of root to the queue, if they exist
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                root = queue.poll();
                currentLevel.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            result.add(currentLevel);
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

        System.out.println(levelOrderTraversal(root));
        assertThat(levelOrderTraversal(root).toString()).isEqualTo("[[12], [7, 1], [9, 10, 5]]");
    }
}


