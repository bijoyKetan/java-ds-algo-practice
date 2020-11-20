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


}
