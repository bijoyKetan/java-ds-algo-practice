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
            result.add(new ArrayList(innerList));
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
}
