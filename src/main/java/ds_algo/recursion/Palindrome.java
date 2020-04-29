package ds_algo.recursion;

import static org.assertj.core.api.Assertions.assertThat;

public class Palindrome {
    //Steps- declare the vars that we need. Call the helper func with those things. return the result.
    public static boolean isPalindromeWithHelper(String s) {
        s = s.toUpperCase();
        char firstLetter = s.charAt(0);
        char lastLetter = s.charAt(s.length() - 1);
        return isPalindromeHelper(firstLetter, lastLetter, s);
    }

    //private helper func. Especially useful when a var/list etc. need to be maintained
    private static boolean isPalindromeHelper(char firstLetter, char lastLetter, String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        if (firstLetter != lastLetter) return false;
        String reducedString = s.substring(1, s.length() - 1);
        return isPalindromeHelper(reducedString.charAt(0), reducedString.charAt(reducedString.length() - 1), reducedString);
    }

    //Direct Recursion
    public static boolean isPalindromeDirect(String s) {
        s = s.toUpperCase();
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindromeDirect(s.substring(1, s.length() - 1));
    }

    //Iterative solution using two pointers
    public static boolean isPalindromeIterative(String s) {
        s = s.toUpperCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        assertThat(isPalindromeDirect("moToR")).isEqualTo(isPalindromeWithHelper("moToR")).isEqualTo(isPalindromeIterative("moToR")).isEqualTo(false);
        assertThat(isPalindromeDirect("rotoR")).isEqualTo(isPalindromeWithHelper("RoToR")).isEqualTo(isPalindromeIterative("roToR")).isEqualTo(true);
    }
}
