package ds_algo.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class ReverseVowels {
    //Reversing vowels using pointers
    //In Java string in immutable so can't just change characters
    public String reverseVowel(String word) {
        char[] arr = word.toCharArray();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (vowelSet.contains(arr[left]) && vowelSet.contains(arr[right])) {
                swap(arr, left++, right--);
            } else if (vowelSet.contains(arr[left])) {
                right--;
            } else if (vowelSet.contains(arr[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        //return Arrays.toString(arr); // Prints each item as str
        //Not the same as the one below
        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Test
    public void testReverseVowels() {
        assertThat(reverseVowel("San Francisco")).isEqualTo("Son Frincasca");
    }
}
