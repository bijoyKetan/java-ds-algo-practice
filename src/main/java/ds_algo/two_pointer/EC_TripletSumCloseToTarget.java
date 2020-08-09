package ds_algo.two_pointer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TripletSumCloseToTarget {
    /*
    Sort the array
    Iterate left to right with for loop and var i
    For each step/i, left and right pointers
    DO NOT calculate sum, sum = arr[i] + arr[left], arr[right], as this may cause OVERFLOW
    Instead, calculate the diff = targetSum - arr[i] - arr[left] - arr[right]
    if diff = 0 i.e. target found, immediately return
    else if diff > 0 , means sum of triplet need to increase. so left ++
            if diff < closestDiff, reassign closestDiff
    if  diff < 0, right --
            if Math.abs(diff) < closestDiff, resign closestDiff
    return targetSum-closestDiff;
    keep a direction variable for over/under
    */
    public int searchTriplet(int[] arr, int targetSum) {

        int closestSum = Integer.MAX_VALUE;
        int closestDiff = Integer.MAX_VALUE;
        int left, right;
        int sum, diff;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            left = i + 1;
            right = arr.length - 1;

            while (left < right) {
                sum = arr[i] + arr[left] + arr[right]; //this may overflow (can be big number)
                diff = targetSum - sum;
                if (sum == targetSum) {
                    return sum;
                } else if (sum < targetSum) {
                    if (diff < closestDiff) {
                        closestSum = sum;
                        closestDiff = diff;
                    }
                    left++;
                } else {
                    if (Math.abs(diff) < closestDiff) {
                        closestSum = sum;
                        closestDiff = diff;
                    }
                    right--;
                }
            }
        }
        return closestSum;
    }

    
    public int searchTriplet2(int[] arr, int targetSum) {

        Arrays.sort(arr);
        int left, right;
        int closestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            left = i + 1;
            right = arr.length - 1;

            while (left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) {
                    return targetSum;
                } else if (diff > 0) {
                    if (diff < closestDiff) {
                        closestDiff = diff;
                    }
                    left++;
                } else {
                    if (Math.abs(diff) < closestDiff) {
                        closestDiff = diff;
                    }
                    right--;
                }

            }
        }
        return targetSum - closestDiff;
    }


    @Test
    void testTripletSumCloseToTarget() {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2)); //1
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1)); //0
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100)); //3

        System.out.println(searchTriplet2(new int[]{-2, 0, 1, 2}, 2)); //1
        System.out.println(searchTriplet2(new int[]{-3, -1, 1, 2}, 1)); //0
        System.out.println(searchTriplet2(new int[]{1, 0, 1, 1}, 100)); //3
    }
}
