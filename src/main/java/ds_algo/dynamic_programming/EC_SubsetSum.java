package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class EC_SubsetSum {
    public boolean canPartition(int[] num, int sum) {

        //Base cases
        if (sum == 0) return true;
        else if (num.length == 0) return false;

        Boolean[][] dp = new Boolean[num.length][sum + 1];

        //Initialization of 1st item values, when target == 0
        //when sum == 0 -> true
        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        //Initialization of target
        //Common mistake  - in this block of code, target => i and
        // we're comparing item[0], i.e. the first item
        for (int i = 0; i <= sum; i++) {
            if (num[0] <= i) { //Common mistake -> num[i] <= i NOT sum
                dp[0][i] = num[0] == i ? true : false;
            }
        }

        for (int row = 1; row < num.length; row++) {
            for (int col = 1; col <= sum; col++) {

                boolean option0 = false, option1 = false;
                //Option 1:  do not pick
                option0 = dp[row - 1][col];

                //Option 2:  pick
                if (num[row] <= col) {
                    option1 = dp[row - 1][col - num[row]];
                }
                dp[row][col] = option0 || option1;
            }
        }
        return dp[num.length - 1][sum];
    }

    @Test
    public void testPartition() {
        int[] num = {1, 2, 3, 7};
        System.out.println(canPartition(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(canPartition(num, 10));
        num = new int[]{1, 3, 4, 8};
        System.out.println(canPartition(num, 6));
    }
}
