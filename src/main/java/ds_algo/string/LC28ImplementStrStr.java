package ds_algo.string;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
public class LC28ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        int ln = needle.length();
        if (ln == 0) return 0;
        for (int i = 0; i <= haystack.length() - ln; i++) {
            if (haystack.substring(i, i + ln).equals(needle)) return i;
        }
        return -1;

    }

    @Test
    public void testCommonCase() {
        assertEquals(2, strStr("hello", "ll"));
    }

    @Test
    public void testNeedleEmpty() {
        assertEquals(0, strStr("hello", ""));
    }

    @Test
    public void testNegative() {
        assertEquals(-1, strStr("aaaaa", "bb"));
    }

}
