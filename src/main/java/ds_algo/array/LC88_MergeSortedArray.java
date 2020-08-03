package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int nums1Index = 0;
        int nums2Index = 0;
        int tempCount = 0;
        while (nums1Index < m && nums2Index < n) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                temp[tempCount] = nums1[nums1Index];
                nums1Index++;
            } else {
                temp[tempCount] = nums2[nums2Index];
                nums2Index++;
            }
            tempCount++;
        }
        //if m has been reached
        if (m == nums1Index) System.arraycopy(nums2, nums2Index, temp, tempCount, n-nums2Index);
        else if(n == nums2Index) System.arraycopy(nums1, nums1Index, temp, tempCount, m-nums1Index);
        System.arraycopy(temp, 0, nums1, 0, nums1.length);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void mergeTest() {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3); // 1,2,2,3,5,6
    }
}
