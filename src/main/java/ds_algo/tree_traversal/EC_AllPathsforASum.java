package ds_algo.tree_traversal;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EC_AllPathsforASum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsHelper(root, sum, paths, currentPath);
        return paths;
    }

    private static void findPathsHelper(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> currentPath) {
        //base case 1
        if (root == null) return;
        //base case 2
        //node processing
        currentPath.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            paths.add(new ArrayList<>(currentPath));
        }
        //recursive steps
        findPathsHelper(root.left, sum, paths, currentPath);
        findPathsHelper(root.right, sum, paths, currentPath);
        //backtracking step
        currentPath.remove(currentPath.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
        assertThat(findPaths(root, 23).toString()).isEqualTo("[[12, 7, 4], [12, 1, 10]]");
    }
}


