package ds_algo.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class EC_LongestSubstringWithKDistinctCharacters {
    //Find the length of the longest substring in it with no more than K distinct characters.
    public static int findLength(String str, int k) {
        // Pseudo code
        //Use a Set for distinct characters
        //Sliding window
        //Counter variable for result
        //keep expanding until set.size() > K
        //Counter -1 is the max so far
        //Then shrink window until set.size == K
        //repeat process and pick the max counter each time
        int maxCounter = 0;
        int start = 0, end = 0;
        Set<Character> charSet = new HashSet<>();
        for (end = 0; end < str.length(); end++) {
            //if (!charSet.contains(str.charAt(end))) charSet.add(str.charAt(end));
            charSet.add(str.charAt(end)); //same logic as the previous line
            while (charSet.size() > k) {
                charSet.remove(str.charAt(start));
                start++;
            }
            maxCounter = Math.max(end - start + 1, maxCounter);
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));
    }
}
