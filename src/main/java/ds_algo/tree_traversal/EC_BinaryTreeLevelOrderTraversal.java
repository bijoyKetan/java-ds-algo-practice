package ds_algo.tree_traversal;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//Create the treenode class, that has value and left and right children (threenodes).
class TreeNode {
    int value;
    TreeNode rightChild;
    TreeNode leftChild;

    TreeNode(int x) {
        this.value = x;
    }
}

public class EC_BinaryTreeLevelOrderTraversal {
    //Given a binary tree, print the levels of the tree.
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelList;
        List<List<Integer>> resultList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            levelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode dequeuedNode = queue.poll();
                levelList.add(dequeuedNode.value);

                if (dequeuedNode.leftChild != null) queue.offer(dequeuedNode.leftChild);
                if (dequeuedNode.rightChild != null) queue.offer(dequeuedNode.rightChild);
                levelList.add(dequeuedNode.value);
            }
            resultList.add(levelList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(1);
        testTree.leftChild = new TreeNode(2);
        testTree.rightChild = new TreeNode(3);
        testTree.leftChild.rightChild = new TreeNode(4);
        testTree.rightChild.leftChild = new TreeNode(5);
        System.out.println(levelOrderTraversal(testTree));
    }
}
