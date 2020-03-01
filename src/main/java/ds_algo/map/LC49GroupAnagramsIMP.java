package ds_algo.map;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC49GroupAnagramsIMP {
    //Given an array of strings, group anagrams together.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String key = sortString(strs[i]);
            if (countMap.containsKey(key)) {
                List<String> valueList = countMap.get(key);
                valueList.add(strs[i]);
                countMap.put(key, valueList);
            } else countMap.put(key, new ArrayList(Arrays.asList(strs[i])));
        }

        for (List<String> l : countMap.values()) {
            resultList.add(l);
        }
        return resultList;
    }

    //private method for sorting string
    private static String sortString(String str) {
        char[] strCharArr = str.toCharArray();
        Arrays.sort(strCharArr);
        return new String(strCharArr); //to convert character array to String, do NOT chaArr.toString()
    }

    @Test
    public void testOne() {
        String[] inputList = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutputList = new ArrayList<>();
        expectedOutputList.add(Arrays.asList("ate", "eat", "tea"));
        expectedOutputList.add(Arrays.asList("bat"));
        expectedOutputList.add(Arrays.asList("nat", "tan"));

        assertEquals(
                sortString(expectedOutputList.toString()),
                sortString(groupAnagrams(inputList).toString()));
    }
}
