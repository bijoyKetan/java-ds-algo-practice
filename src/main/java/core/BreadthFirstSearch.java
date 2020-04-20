package core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
    //Add the root
    //Do the following until queue is empty (while !queue.isEmpty())
    //Iterate over the queue of size s, poll the items
    //Add the polled item to an inner list
    //For each polled item, check if right node exists and if left node exists
    //Add the left and right children to the queue
    public static List<List<Integer>> LevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //Check for empty tree
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
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

        System.out.println(LevelOrderTraversal(root));

    }

}


