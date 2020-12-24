package ds_algo.string;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LC451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        /*
        tree -> eert
        Aabb -> bbAa

        Iterate through the string and get a freq map
        Make a list of the keys, sorted by frequency.
        Convert the counts into a string with a sb.
         */

        if (s.length() < 2) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (x, y) -> map.get(y) - map.get(x));

        StringBuilder sb = new StringBuilder();

        for (Character c : keyList) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }

    public String frequencyBucketSort(String s) {
        /*
        Create freq map of characters
        Keep track of max freq
        Create an array of size maxFreq
        Iterate through map and put the characters in array
        Iterate through array in reverse order and build the word
         */

        if (s == null || s.length() < 2) return s;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            //maxFreq = Math.max(maxFreq, map.get(c));
            if (maxFreq < map.get(c)) maxFreq = map.get(c);
        }

        StringBuilder[] arr = new StringBuilder[maxFreq + 1];
        //Note: For objects java created arr with nulls
        //Note: For map iteration, keySet is enough, no need for entrySet()
        for (Character c : map.keySet()) {
            int freq = map.get(c);
            StringBuilder sb = new StringBuilder();
            while (freq > 0) {
                sb.append(c);
                freq--;
            }
            //Null checks very important for string builder
            arr[map.get(c)] = arr[map.get(c)] != null ? sb.append(arr[map.get(c)]) : sb;
        }

        StringBuilder result = new StringBuilder();
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != null) {
                result.append(arr[i]);
            }
        }
        return result.toString();
    }


    @Test
    void testFrequencySort() {
        assertThat(frequencySort("tree")).isEqualTo("eert");
        assertThat(frequencySort("Aabb")).isEqualTo("bbAa");

        assertThat(frequencyBucketSort("tree")).isIn("eert", "eetr");
        assertThat(frequencyBucketSort("Aabb")).isIn("bbAa", "bbaA");
    }
}
