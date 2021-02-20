package ds_algo.combination_permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationsPermutationsQuestions {

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


}
