package ds_algo.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class EC_NoRepeatSubstring {
    //Find length of substring with no repeating characters
    public static int findLength(String str) {
        //Map of character count
        //sliding window of length end-start+1
        //success condition: map.size() == window length
        int start = 0;
        int end = 0;
        int maxCount = 0;
        int windowSize;
        Map<Character, Integer> charMap = new HashMap<>();
        for (end = 0; end < str.length(); end++) {
            windowSize = end - start + 1;
            charMap.put(str.charAt(end), charMap.getOrDefault(str.charAt(end), 0) + 1);
            while (charMap.size() != windowSize) {
                charMap.put(str.charAt(start), charMap.get(str.charAt(start)) - 1);
                if (charMap.get(str.charAt(start)) == 0) {
                    charMap.remove(str.charAt(start));
                }
                //Possible optimization => instead of sliding the start by 1, slide to the index where repeat happens
                //start = Math.max(start, charMap.get(str.charAt(start)));
                //start ++;
                //OR start = Math.max(start, chatMap.get(str.charAt(start) +1));
                start++;
                windowSize--;
            }
            maxCount = Math.max(maxCount, windowSize);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("aabccbb")); //Expected 3
        System.out.println("Length of the longest substring: " + findLength("abbbb")); //Expected 2
        System.out.println("Length of the longest substring: " + findLength("abccde"));// Expected 3
    }
}