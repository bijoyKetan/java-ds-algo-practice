package ds_algo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC27RemoveElement {
    //Technique - one slow pointer, i, that waiting for the faster pointers comparison and then get the change,
    //One fast pointer, j, that moves and does the comparison.
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    @Test
    public void testRepeatedElements() {
        assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    @Test
    public void testEmptyArr() {
        assertEquals(0, removeElement(new int[]{}, 1));
    }
}
