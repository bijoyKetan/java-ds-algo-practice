package core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CommonMistakes {
    @Test
    public void commonMistakes() {
        String str = "Treehouse";
        str.substring(0, str.length()); //not subString
        str.equals("");// not str.isEqualTo();


        //For subsequences can't just do two loops
        // (substring is not the same as subsequences -> m x (m-1) x ... 1)
        //In nested loops, check where the inner loop need to start from
        int end = 3;
        for (int i = 0; i < end; i++) {
            for (int j = i; j < end; j++) {
                for (int k = j; k < end; k++) {
                    System.out.println(Arrays.toString(new int[]{i, j, k}));
                }
            }
        }


        //Dynamic Programming  - Initialization of target
        //Common mistake  - in this block of code, target => i and
        // we're comparing item[0], i.e. the first item
        int sum = 1;
        int[] num = new int[5];
        boolean[][] dp = new boolean[5][5];
        for (int i = 0; i <= sum; i++) {
            if (num[0] <= i) { //Common mistake -> num[i] <= i NOT sum
                dp[0][i] = num[0] == i ? true : false;
            }
        }



    }
}
