package ds_algo.linkedList;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LC_202HappyNumber {

    public boolean find(int num) {
        Set<Integer> sumSet = new HashSet<>();
        int n = sumSquare(num);
        while (n != 1 && !sumSet.contains(n)) {
            sumSet.add(n);
            n = sumSquare(n);
        }
        return n == 1;
    }

    private int sumSquare(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (int) Math.pow(num % 10, 2);
            num = num / 10;
        }
        return sum;
    }

    @Test
    public void testHappyNum() {
        System.out.println(find(23));
        System.out.println(find(12));
    }

    @Test
    public void testSumSquare() {
        System.out.println(sumSquare(23)); //13
    }
}
