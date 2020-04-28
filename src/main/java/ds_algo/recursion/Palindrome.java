package ds_algo.recursion;

import static org.assertj.core.api.Assertions.assertThat;

public class Palindrome {
    public static boolean isPalindromeWithHelper(String s) {
        s= s.toUpperCase();
        char firstLetter = s.charAt(0);
        char lastLetter = s.charAt(s.length() - 1);
        return isPalindromeHelper(firstLetter, lastLetter, s);
    }

    private static boolean isPalindromeHelper(char firstLetter, char lastLetter, String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        if (firstLetter != lastLetter) return false;
        String reducedString = s.substring(1, s.length() - 1);
        return isPalindromeHelper(reducedString.charAt(0), reducedString.charAt(reducedString.length() - 1), reducedString);
    }

    public static boolean isPalindromeDirect(String s) {
        s= s.toUpperCase();
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindromeDirect(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        assertThat(isPalindromeDirect("moToR")).isEqualTo(isPalindromeWithHelper("moToR")).isEqualTo(false);
        assertThat(isPalindromeDirect("rotoR")).isEqualTo(isPalindromeWithHelper("RoToR")).isEqualTo(true);
    }
}
