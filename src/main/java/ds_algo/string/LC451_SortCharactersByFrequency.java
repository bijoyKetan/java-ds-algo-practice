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

    @Test
    void testFrequencySort() {
        assertThat(frequencySort("tree")).isEqualTo("eert");
        assertThat(frequencySort("Aabb")).isEqualTo("bbAa");
    }
}
