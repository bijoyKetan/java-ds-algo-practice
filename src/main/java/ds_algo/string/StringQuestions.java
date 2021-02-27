package ds_algo.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringQuestions {

    /////////////////////////////////////////////////////////////////////

  /*
  151. Reverse Words in a String
  Given an input string s, reverse the order of the words.
  Result must not have any trailing spaces and words separated by one space.

  Input: s = "   the sky is   blue    "
  Output: "blue is sky the"
  */

    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        reverse(c, 0, s.length() - 1);
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < c.length) {
            if (j == 0) {
                j++;
            } else {
                //spaces
                if (c[j] == ' ' && c[j - 1] == ' ') {
                    j++;
                    i++;
                }
                //end of word
                else if (c[j] == ' ' && c[j - 1] != ' ') {
                    reverse(c, i, j - 1);
                    sb.append(new String(Arrays.copyOfRange(c, i, j)));
                    sb.append(" ");
                    j++;
                }
                //Start of word
                else if (c[j] != ' ' && c[j - 1] == ' ') {
                    i = j;
                    j++;
                }
                //traversing the word
                else {
                    j++;
                }
            }
        }
        if (c[j-1] != ' '){
            reverse(c, i, j-1);
            sb.append(new String(Arrays.copyOfRange(c, i, j)));
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private static void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    void reverseWordsTest() {
        assertThat(reverseWords("   the sky is   blue    ")).isEqualTo("blue is sky the");
        assertThat(reverseWords("  hello world  ")).isEqualTo("world hello");
        assertThat(reverseWords("hello world")).isEqualTo("world hello");
        assertThat(reverseWords("hello")).isEqualTo("hello");
    }
}
