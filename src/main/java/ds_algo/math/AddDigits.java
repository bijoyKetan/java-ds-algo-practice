package ds_algo.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigits {
    /*
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    Example:

    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.
     */
    public int addDigits(int num) {

        while(num / 10 > 1){
            num = sumDigits(num);
        }
        return num;
    }

    public int sumDigits(int n) {
        if (n == 0) return 0;
        else return ((n % 10) + (n / 10));
    }


    @Test
    public void testFunction() {
        assertEquals(7, addDigits(583));
    }

    @Test
    public void testFunction2() {
        assertEquals(addDigits(1), 1);
    }


}


