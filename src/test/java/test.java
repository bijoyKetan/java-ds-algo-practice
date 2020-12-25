import org.junit.jupiter.api.Test;

import java.util.*;

public class test {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int weight = A[0];
        if (A.length < 2) return 0; //no apples in box
        int[] apples = Arrays.copyOfRange(A, 1, A.length);

        Arrays.sort(apples);
        for (int i = 0; i < apples.length; i++) {
            if (weight + apples[i] < 5000) {
                weight += apples[i];
            } else {
                return i;
            }
        }

        return apples.length;

    }

    @Test
    public void test() {
        int[] input = new int[]{4850, 100, 30, 30, 100, 50, 100};
        System.out.println(solution(input));
    }

    public int[] solution2(int[] A) {
        // write your code in Java SE 8

        boolean changed = true;
        int prev = A[0];

        while (changed) {
            changed = false;
            for (int i = 1; i < A.length - 1; i++) {
                int next = A[i + 1];
                int curr = A[i];
                if (curr < prev && curr < next) {
                    prev = curr;
                    curr++;
                    changed = true;
                } else if (curr > prev && curr > next) {
                    prev = curr;
                    curr--;
                    changed = true;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        return A;


    }

    @Test
    public void test2() {
        int[] input = new int[]{1, 6, 3, 4, 3, 5};
        System.out.println(Arrays.toString(solution2(input)));
    }

    @Test
    public void testQuotient() {


        System.out.println(getSquareSum(82));
    }

    private int getSquareSum(int n) {
        int remainder = n % 10;
        int quotient = n / 10;
        Deque<Integer> stack = new ArrayDeque<>();
        while (quotient > 0) {
            stack.push(remainder);
            remainder = quotient % 10;
            quotient = quotient / 10;
        }
        stack.push(remainder);
        int sum = 0;
        for (Integer i : stack) {
            sum += (i * i);
        }
        return sum;
    }

    static class PrintArray {

        public static void compute(int[] arr) {
            // YOUR WORK HERE
            computeHelper(arr, 0);
        }

        public static void computeHelper(int[] arr, int index) {
            // YOUR WORK HERE
            if (index >= arr.length) return;
            System.out.println(arr[index]);
            computeHelper(arr, index + 1);
        }
    }

    @Test
    public void recursionTest() {
        PrintArray.compute(new int[]{1, 23, 4, 5, 6});

    }

    public static String compute(String str) {
        // YOUR WORK HERE
        char[] arr = str.toCharArray();
        return helper(arr, 0);
    }

    private static String helper(char[] arr, int index) {
        if (index >= arr.length / 2) return new String(arr);
        char temp = arr[index];
        arr[index] = arr[arr.length - index - 1];
        arr[arr.length - index - 1] = temp;
        return helper(arr, index + 1);
    }

    @Test
    public void recursionReverseTest() {
        System.out.println(compute("ABCDEF"));
    }

    @Test
    public void testMatrix() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] dp = matrix.clone();
        dp[0][0] = 9;
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(matrix[0])); //Both are changed. Copy by reference
    }

    public int maxSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        return -1;
    }


    //---------------------------------------------------------//
    ////////////////FREQ COUNT & STRING PROBLEMS ////////////////
    //---------------------------------------------------------//

    public HashMap<String, Integer> wordCount(String sentence) {
        if (sentence.equals("")) return new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        sentence = sentence
                .toLowerCase()
                .replaceAll("[-.!,']", "");
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map.toString());
        return map;
    }

    @Test
    public void testWordCount() {
        //wordCount("It's a man, it's a plane, it's superman!");
        wordCount("");
    }

    public void ascII(String word) {
        for (Character c : word.toCharArray()) {
            System.out.println(String.format("Character %s : %s", c, (int) c));
        }
    }

    @Test
    void ascIITest() {
        ascII("abcdefzABCDXYZ");
    }

    public String letterSort(String string) {
        int[] chars = new int[26];
        Arrays.fill(chars, 0);
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            int charIndex = (int) Character.toLowerCase(string.charAt(i)) - 97;
            chars[charIndex] = chars[charIndex] + 1;
        }
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] > 0) {
                char letter = (char) (i + 97);
                result += letter;
                chars[i] -= 1;
            }
        }
        System.out.println(result);
        return result;
    }

    public String letterSort2(String string) {
        //Pseudo code
        /*
        Create map of counts
            key -> letter
            val -> count
        Iterate through alphabet in ASCII
        Form the word in sorted order
         */

        string = string.toLowerCase();
        //Edge case
        if (string.length() <= 1) return string;

        Map<Character, Integer> map = new HashMap<>();
        char[] arr = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (Character c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            //getOrDefault needed since get may return null
            int count = map.getOrDefault(c, 0);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Test
    public void testLetterSort() {
        letterSort("hello");
        letterSort2("hello");
    }

    public static String characterMode(String string) {
        /*
        Iterate through input string
        Frequency count of letters
        check for max freq.
        for equal max freq, add to result string
        return result string
         */
        if (string.length() <= 1) return string;
        string = string.toLowerCase().replace(" ", "");
        char[] arr = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int maxCount = 0;

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxCount) {
                maxCount = map.get(c);
                sb = new StringBuilder().append(c);
            } else if (map.get(c) == maxCount) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Test
    void testCharacterMode() {
        characterMode("noon");
    }


    public static int sortDigits(int n) {
        /*
        70343 -> 3347
        Map of count of the digits
        Iterate through 1-9 and find the count from map
        result = result * 10 + remainder
         */

        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int remainder = n % 10;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            n /= 10;
        }

        n = 0;
        for (int i = 1; i < 10; i++) {
            int val = map.getOrDefault(i, 0);
            while (val > 0) {
                n = n * 10 + i;
                val--;
            }
        }
        System.out.println(map.toString());
        System.out.println(n);
        return n;
    }

    @Test
    void testSortDigits() {
        sortDigits(70343);
    }

    public static ArrayList<Integer> getDuplicates(int[] arr) {
        /*
        Iterate through array
        Create a frequency map
        if count == 2 add to result list
        return resultList
         */
        if (arr.length < 2) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == 2) result.add(i);
        }
        System.out.println(result.toString());
        return result;
    }

    @Test
    void testDuplicate() {
        getDuplicates(new int[]{1, 2, 4, 2});
    }

    public static boolean anagramPair(String string1, String string2) {
        /*
        Iterate through string1
        Create map of character counts
        Iterate through string2
        Decrease character count from map
        Iterate through map and check if all counts are zero
         */

        //Base check
        if (string1.length() != string2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        //Iterate through str1 and create map
        for (Character c : string1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //Iterate through str2 and decrease map counts
        for (Character c : string2.toCharArray()) {
            if (map.get(c) == null || map.get(c) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        //Check if map values are all 0
        for (int i : map.values()) {
            if (i != 0) return false;
        }
        return true;
    }

    @Test
    void testAnagram() {
        System.out.println(anagramPair("cat", "act"));
        System.out.println(anagramPair("cat", "dog"));
    }

    public static boolean anagramPalindrome(String str) {
        /*
        Frequency count of characters
        if length is even then all values should be even
        if length is odd then:
            Exactly one letter should be odd
            Others should be even

         */
        if (str.length() < 2) return true;
        Map<Character, Integer> map = new HashMap<>();
        int size = str.length();

        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //The following works, but for even size
        //only one letter count can't be odd
        //so both both odd and even
        // odd count must < 2

        /*
        boolean oneOdd = false;
        for (int i : map.values()) {
            if (size % 2 == 0 && i % 2 != 0) {
                return false;
            } else if (size % 2 != 0 && i % 2 != 0) {
                if (!oneOdd) oneOdd = true;
                else return false;
            }
        }
        return true;
         */
        int oddCount = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }

    @Test
    void testAnagramPalindrome() {
        System.out.println(anagramPalindrome("carrace"));
        System.out.println(anagramPalindrome("cat"));
        System.out.println(anagramPalindrome("a"));
    }

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
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));
    }
}
