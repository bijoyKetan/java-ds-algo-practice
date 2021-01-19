package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class LC5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] c = s.toCharArray();
        int left, right;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < c.length; i++) {
            //i as center
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < c.length && c[left] == c[right]) {
                if (right - left > maxRight - maxLeft) {
                    maxLeft = left;
                    maxRight = right;
                }
                left--;
                right++;
            }

            //i and i-1 as center
            left = i - 1;
            right = i;
            while (left >= 0 && right < c.length && c[left] == c[right]) {
                if (right - left > maxRight - maxLeft) {
                    maxLeft = left;
                    maxRight = right;
                }
                left--;
                right++;
            }
        }
        return new String(c, maxLeft, maxRight - maxLeft + 1);
    }

    @Test
    public void testLongestPalindrome() {
        System.out.println(longestPalindrome("asdasade"));
        System.out.println(longestPalindrome("taat"));
        System.out.println(longestPalindrome("atatd"));
    }
}
