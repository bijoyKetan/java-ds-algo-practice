package ds_algo.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class EC_LongestSubstringWithKDistinctCharacters {
    //Find the length of the longest substring in it with no more than K distinct characters.
    public static int findLength(String str, int k) {
        //Pseudo code
        //Sliding window of variable length
        //slide end pointer and keep count of the frequency of distinct letters
        //if map.size() > k, keep sliding start pointer to reduce window size
        //keep sliding start pointer until map size <= K
        //Keep track of the max window size (result)
        //Finally add input validation

        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException("Input is invalid");
        }

        Map<Character, Integer> charMap = new HashMap<>();
        int maxCount = 0;
        int start = 0;
        int end = 0;
        for (end = 0; end < str.length(); end++) {
            //In each iteration, slight the end pointer by one (always happens)
            charMap.put(str.charAt(end), charMap.getOrDefault(str.charAt(end), 0) + 1);
            //Continue to shrink the window as long as successful criteria not met
            while (charMap.size() > k) {
                if (charMap.get(str.charAt(start)) == 1) charMap.remove(str.charAt(start));
                else charMap.put(str.charAt(start), charMap.get(str.charAt(start)) - 1);
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
        System.out.println("Length of the longest substring: " + findLength("abaccc", 2));//should be 4
    }
}
