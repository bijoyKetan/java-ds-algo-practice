package ds_algo.backtracking;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BackTrackingQuestions {

    /////////////////////////////////////////////////////////////////////

    /*
    LC 22. Generate Parentheses
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    */

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, "", 0, 0);
        return result;
    }

    private static void helper(List<String> arr, int n, String s, int left, int right) {
        if (right > left || left > n) { //base cases
            return;
        }

        if (right == n) { //last level, so the results to be added
            arr.add(s);
            return;
        }
        //Recursive cases
        helper(arr, n, s + "(", left + 1, right);
        helper(arr, n, s + ")", left, right + 1);
    }

    @Test
    void generateParenthesisTest() {
        assertThat(generateParenthesis(3)).isEqualTo(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
    }


    /////////////////////////////////////////////////////////////////////

    /*
    39. Combination Sum
    Given an array of distinct integers candidates and a target integer target,
    return a list of all unique combinations of candidates
    where the chosen numbers sum to target

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> innerList = new ArrayDeque<>();
        helper(candidates, target, 0, innerList, result);
        return result;
    }

    private static void helper(int[] candidates, int target, int index, Deque<Integer> innerList, List<List<Integer>> result) {
        //base case
        if (target < 0) {
            return;
        }

        //successful result
        else if (target == 0) {
            result.add(new ArrayList<>(innerList));
            return;
        }

        //starting i  at index ensures combination instead of permutation
        for (int i = index; i < candidates.length; i++) {
            innerList.add(candidates[i]);
            helper(candidates, target - candidates[i], i, innerList, result);
            innerList.removeLast();
        }
    }

    @Test
    void combinationSumTest() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    /////////////////////////////////////////////////////////////////////

    /*
    40. Combination Sum II
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [[1,2,2], [5]]
    */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> innerDeque = new ArrayDeque<>();
        helper(candidates, target, result, innerDeque, 0);
        return result;
    }

    private static void helper(int[] candidates, int target, List<List<Integer>> result, Deque<Integer> innerDeque, int index) {

        if (target < 0) return;
        else if (target == 0) {
            result.add(new ArrayList<>(innerDeque));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            innerDeque.add(candidates[i]);
            helper(candidates, target - candidates[i], result, innerDeque, i + 1);
            innerDeque.removeLast();
        }
    }

    @Test
    void combinationSum2Test() {
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)); //[[1, 2, 2], [5]]
    }


    /////////////////////////////////////////////////////////////////////

    /*
    216. Combination Sum III
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    */

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        helper(k, n, 1, result, innerList);
        return result;
    }

    private static void helper(int k, int n, int start, List<List<Integer>> result, List<Integer> innerList) {
        if (n < 0 || innerList.size() > k) return;

        else if (n == 0 && innerList.size() == k) {
            result.add(new ArrayList<>(innerList));
            return;
        }

        for (int i = start; i <= 9; i++) {
            innerList.add(i);
            //Note: k not changing since innerList gets compared to that
            helper(k, n - i, i + 1, result, innerList);
            innerList.remove(innerList.size() - 1);
        }
    }

    @Test
    void combinationSum3Test() {
        System.out.println(combinationSum3(3, 9)); //[[1,2,6],[1,3,5],[2,3,4]]
    }

    /////////////////////////////////////////////////////////////////////

      /*
      377. Combination Sum IV
      Given an integer array with all positive numbers and no duplicates,
      find the number of possible combinations that add up to a positive integer target.
      */

    // *** NOTE *** //
    /*
    correct dp definition should be dp[i][j]="number of ways to get sum 'j' using 'first i' coins".
    Now when we try to traverse the 2-d array row-wise by keeping only previous row array(to reduce space complexity),
    we preserve the above dp definition as dp[j]="number of ways to get sum 'j' using 'previous /first i coins' "
    but when we try to traverse the 2-d array column-wise by keeping only the previous column, the meaning of dp array
    changes to dp[j]="number of ways to get sum 'j' using 'all' coins".
    */

    //Number of permutations using dp
    public int permutationSum(int[] nums, int target) {
        Arrays.sort(nums); //Optimization
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int r = 1; r <= target; r++) {
            for (int num : nums) {
                if (r >= num) dp[r] += dp[r - num];
                else break; //early termination as rest of nums are bigger than target
            }
        }
        return dp[target];
    }

    //Number of permutations using dp
    public int combSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);//Optimization
        for (int num : nums) {
            for (int c = num; c <= target; c++) {
                dp[c] = dp[c] + dp[c - num];
            }
        }
        return dp[target];
    }

    //Permutations recursive
    public int permNCombRecursive(int[] nums, int target) {
        int[] result = new int[1];
        helper(nums, target, 0, result);
        return result[0];
    }

    private void helper(int[] nums, int target, int index, int[] result) {
        if (target == 0) {
            result[0]++;
            return;
        } else if (target < 0) return;

        //Permutation - trying all options with current item
//        for (int i = 0; i < nums.length; i++) {
//            helper(nums, target - nums[i], i, result);
//        }

        //Combinations - combinations of unused items from this item forward
        for (int i = index; i < nums.length; i++) {
            helper(nums, target - nums[i], i , result);
        }
    }



    @Test
    void combinationSum4Test() {
        System.out.println("Permutations: " + permutationSum(new int[]{1, 2, 3}, 4)); //7
        System.out.println("Combinations: " + combSum(new int[]{1, 2, 3}, 4)); //4
        System.out.println("Permutations & Combination Recursive: " + permNCombRecursive(new int[]{1, 2, 3}, 4)); //7 & 4
    }

}
