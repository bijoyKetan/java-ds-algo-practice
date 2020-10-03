package ds_algo.sliding_window;

import org.junit.jupiter.api.Test;

public class LC1180CountSubStringsWithOneDistinctLetter {
    public int countLetters(String S) {

        int count = 0;
        int start = 0;
        int end = 0;
        int result = 0;

        for (end = 0; end < S.length(); end++) {
            if (S.charAt(start) == S.charAt(end)) {
                count++;
            } else {
                count = 1;
                start = end;
            }
            result += count;
        }
        return result;
    }

    @Test
    public void testFactorial() {
        System.out.println(countLetters("aaaba"));
        System.out.println(countLetters("aaaaaaaaaa"));
    }

}
