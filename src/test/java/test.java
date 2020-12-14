import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    private int getSquareSum(int n){
        int remainder = n % 10;
        int quotient = n / 10;
        Deque<Integer> stack = new ArrayDeque<>();
        while (quotient > 0){
            stack.push(remainder);
            remainder = quotient % 10;
            quotient = quotient / 10;
        }
        stack.push(remainder);
        int sum = 0;
        for (Integer i: stack){
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
            computeHelper(arr, index +1);
        }
    }

    @Test
    public void recursionTest(){
        PrintArray.compute(new int[]{1,23,4,5,6});

    }

    public static String compute(String str) {
        // YOUR WORK HERE
        char[] arr = str.toCharArray();
        return helper(arr, 0);
    }

    private static String helper(char[] arr, int index) {
        if (index >= arr.length/ 2) return new String(arr);
        char temp = arr[index];
        arr[index] = arr[arr.length - index -1];
        arr[arr.length - index -1] = temp;
        return helper(arr, index +1);
    }

    @Test
    public void recursionReverseTest(){
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

    public int maxSquare(char[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0; i< matrix.length; i++){
            for (int j = 0; j< matrix[0].length; j++){
                dp[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        return -1;
    }
}
