package ds_algo.dynamic_programming;

import static org.assertj.core.api.Assertions.assertThat;

public class LC_1143LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int row = 0; row <= m; row++) {
            for (int col = 0; col <= n; col++) {
                if (row == 0) dp[0][col] = 0;
                else if (col == 0) dp[row][0] = 0;
                else if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        assertThat(longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
    }
}
