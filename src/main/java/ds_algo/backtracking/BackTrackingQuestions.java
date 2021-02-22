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
}
