package ds_algo.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class EC_FruitsIntoBaskets {

    public static int findLength(char[] arr) {
        //Pseudo code
        // Map for the frequency of characters
        //sliding window of variable length
        //when the map.size > 2, shrink the map
        //output max window size

        if (arr == null || arr.length < 2) throw new IllegalArgumentException("Invalid input");

        int start = 0;
        int end = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int maxCount = 0;
        int totalFruits = 0;

        for (end = 0; end < arr.length; end++) {
            charMap.put(arr[end], charMap.getOrDefault(arr[end], 0) + 1);
            while (charMap.size() > 2) {
                charMap.put(arr[start], charMap.get(arr[start]) - 1);
                if (charMap.get(arr[start]) == 0) {
                    charMap.remove(arr[start]);
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                findLength(new char[]{'A', 'B', 'C', 'A', 'C'})); // Expected 3
        System.out.println("Maximum number of fruits: " +
                findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})); // Expected 5
    }
}
