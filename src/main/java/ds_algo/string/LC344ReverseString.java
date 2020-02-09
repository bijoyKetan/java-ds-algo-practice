package ds_algo.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC344ReverseString {

    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        else {
            int p1 = 0, p2 = s.length - 1;
            char c;
            while (p1 < p2) {
                c = s[p1];
                s[p1] = s[p2];
                s[p2] = c;
                p1++;
                p2--;
            }
        }

    }

    @Test
    public void testEmptyInput() {
        char[] expected = {};
        char[] result = {};
        reverseString(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleInput() {
        char[] expected = {'a'};
        char[] result = {'a'};
        reverseString(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEvenLengthInput() {
        char[] expected = {'r', 'o', 'o', 'd'};
        char[] result = {'d', 'o', 'o', 'r'};
        reverseString(result);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOddLengthInput() {
        char[] expected = {'o', 'l', 'l', 'e', 'h'};
        char[] result = {'h', 'e', 'l', 'l', 'o'};
        reverseString(result);
        assertArrayEquals(expected, result);
    }

}
